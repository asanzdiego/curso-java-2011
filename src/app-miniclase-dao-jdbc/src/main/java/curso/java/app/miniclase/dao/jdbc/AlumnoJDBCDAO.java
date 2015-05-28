/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import curso.java.app.miniclase.dao.AlumnoDAO;
import curso.java.app.miniclase.dao.jdbc.proxies.AlumnoProxy;
import curso.java.app.miniclase.dao.jdbc.templates.DeleteTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindListTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindObjectTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.Mapeador;
import curso.java.app.miniclase.dao.jdbc.templates.PersistTemplate;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 */
public class AlumnoJDBCDAO extends AbstractJDBCDAO implements AlumnoDAO {

    private final Mapeador<Alumno> mapeador = new Mapeador<Alumno>() {

        @SuppressWarnings("nls")
        public Alumno mapearObjeto(final ResultSet cursor) throws Exception {
            final Alumno alumno = new AlumnoProxy(AlumnoJDBCDAO.this
                    .getConnection());
            alumno.setId((Long) cursor.getObject("ID_PERSONA"));
            alumno.setNombre(cursor.getString("NOMBRE"));
            alumno.setApellidos(cursor.getString("APELLIDOS"));
            final Long idClase = (Long) cursor.getObject("ID_CLASE");
            final ClaseJDBCDAO claseJDBCDAO = new ClaseJDBCDAO(
                    AlumnoJDBCDAO.this.getConnection());
            final Clase clase = claseJDBCDAO.findByIdClase(idClase);
            alumno.setClase(clase);
            return alumno;
        }

    };

    /**
     * @param connection
     */
    public AlumnoJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#findAll()
     */
    @SuppressWarnings("nls")
    public List<Alumno> findAll() {
        final FindListTemplate<Alumno> findListTemplate = new FindListTemplate<Alumno>() {

            @Override
            public void addParametros(final PreparedStatement sentencia) {
                // sin parametros
            }
        };

        final List<Alumno> alumnos = findListTemplate.findList(this
                .getConnection(), "SELECT p.*, a.ID_CLASE "
                + "FROM ALUMNOS a, PERSONAS p "
                + "WHERE a.ID_PERSONA = p.ID_PERSONA", this.mapeador);

        return alumnos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.AlumnoDAO#findByIdAlumno(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public Alumno findByIdAlumno(final Long idAlumno) {
        final FindObjectTemplate<Alumno> findObjectTemplate = new FindObjectTemplate<Alumno>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idAlumno);
            }
        };

        final Alumno alumno = findObjectTemplate.findObject(this
                .getConnection(), "SELECT p.*, a.ID_CLASE "
                + "FROM ALUMNOS a, PERSONAS p "
                + "WHERE a.ID_PERSONA = p.ID_PERSONA AND p.ID_PERSONA = ?",
                this.mapeador);

        return alumno;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.AlumnoDAO#findByIdClase(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public List<Alumno> findByIdClase(final Long idClase) {
        final FindListTemplate<Alumno> findListTemplate = new FindListTemplate<Alumno>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idClase);
            }
        };

        final List<Alumno> alumnos = findListTemplate.findList(this
                .getConnection(), "SELECT p.*, a.ID_CLASE "
                + "FROM ALUMNOS a, PERSONAS p "
                + "WHERE a.ID_PERSONA = p.ID_PERSONA AND a.ID_CLASE = ?",
                this.mapeador);

        return alumnos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Alumno)
     */
    @SuppressWarnings("nls")
    public void persist(final Alumno alumno) {
        final PersonaJDBCDAO personaJDBCDAO = new PersonaJDBCDAO(this
                .getConnection());
        personaJDBCDAO.persist(alumno);
        final PersistTemplate persistObjectTemplate = new PersistTemplate() {

            @Override
            public boolean isNew() {
                final AlumnoJDBCDAO alumnoJDBCDAO = new AlumnoJDBCDAO(
                        AlumnoJDBCDAO.this.getConnection());
                return alumnoJDBCDAO.findByIdAlumno(alumno.getId()) == null;
            }

            @Override
            public void addInsertParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, alumno.getId());
                sentencia.setObject(2, alumno.getClase() == null ? null
                        : alumno.getClase().getId());
            }

            @Override
            public void addUpdateParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, alumno.getClase() == null ? null
                        : alumno.getClase().getId());
                sentencia.setObject(2, alumno.getId());
            }

            @Override
            public void setIdObjeto(final Long nuevoId) {
                // ho hay que hacer nada (se actualiza idPersona)
            }
        };
        persistObjectTemplate.persistObject(this.getConnection(),
                "INSERT INTO ALUMNOS (ID_PERSONA, ID_CLASE) VALUES (?, ?)",
                "UPDATE ALUMNOS SET ID_CLASE = ? WHERE ID_PERSONA = ?");
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#delete(curso.java.app.miniclase.pojosanotados.Alumno)
     */
    @SuppressWarnings("nls")
    public void remove(final Alumno alumno) {
        final DeleteTemplate deleteCalificaciones = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, alumno.getId());
            }

        };
        deleteCalificaciones.delete(this.getConnection(),
                "DELETE FROM CALIFICACIONES WHERE ID_ALUMNO = ?");
        final DeleteTemplate deleteAlumno = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, alumno.getId());
            }

        };
        deleteAlumno.delete(this.getConnection(),
                "DELETE FROM ALUMNOS WHERE ID_PERSONA = ?");
        final DeleteTemplate deletePersona = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, alumno.getId());
            }

        };
        deletePersona.delete(this.getConnection(),
                "DELETE FROM PERSONAS WHERE ID_PERSONA = ?");
    }

}
