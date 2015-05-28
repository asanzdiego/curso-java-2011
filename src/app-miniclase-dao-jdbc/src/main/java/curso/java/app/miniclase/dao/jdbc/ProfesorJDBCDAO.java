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

import curso.java.app.miniclase.dao.ProfesorDAO;
import curso.java.app.miniclase.dao.jdbc.proxies.ProfesorProxy;
import curso.java.app.miniclase.dao.jdbc.templates.DeleteTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindListTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindObjectTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.Mapeador;
import curso.java.app.miniclase.dao.jdbc.templates.PersistTemplate;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 */
public class ProfesorJDBCDAO extends AbstractJDBCDAO implements ProfesorDAO {

    private final Mapeador<Profesor> mapeador = new Mapeador<Profesor>() {

        @SuppressWarnings("nls")
        public Profesor mapearObjeto(final ResultSet cursor) throws Exception {
            new Profesor();
            final Profesor profesor = new ProfesorProxy(ProfesorJDBCDAO.this
                    .getConnection());
            profesor.setId((Long) cursor.getObject("ID_PERSONA"));
            profesor.setNombre(cursor.getString("NOMBRE"));
            profesor.setApellidos(cursor.getString("APELLIDOS"));
            return profesor;
        }

    };

    /**
     * @param connection
     */
    public ProfesorJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#findAll()
     */
    @SuppressWarnings("nls")
    public List<Profesor> findAll() {
        final FindListTemplate<Profesor> findListTemplate = new FindListTemplate<Profesor>() {

            @Override
            public void addParametros(final PreparedStatement sentencia) {
                // sin parametros
            }
        };

        final List<Profesor> clases = findListTemplate.findList(this
                .getConnection(), "SELECT p.* "
                + "FROM PROFESORES ps, PERSONAS p "
                + "WHERE ps.ID_PERSONA = p.ID_PERSONA", this.mapeador);

        return clases;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.ProfesorDAO#findByIdProfesor(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public Profesor findByIdProfesor(final Long idProfesor) {
        final FindObjectTemplate<Profesor> findObjectTemplate = new FindObjectTemplate<Profesor>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idProfesor);
            }
        };

        final Profesor profesor = findObjectTemplate.findObject(this
                .getConnection(), "SELECT p.* "
                + "FROM PROFESORES ps, PERSONAS p "
                + "WHERE ps.ID_PERSONA = p.ID_PERSONA AND p.ID_PERSONA = ?",
                this.mapeador);

        return profesor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.ProfesorDAO#findByIdClase(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public List<Profesor> findByIdClase(final Long idClase) {
        final FindListTemplate<Profesor> findListTemplate = new FindListTemplate<Profesor>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idClase);
            }
        };

        final List<Profesor> profesors = findListTemplate.findList(this
                .getConnection(), "SELECT p.* "
                + "FROM PERSONAS p, PROFESORES_CLASE pc "
                + "WHERE p.ID_PERSONA = pc.ID_PERSONA AND pc.ID_CLASE = ?",
                this.mapeador);

        return profesors;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Profesor)
     */
    @SuppressWarnings("nls")
    public void persist(final Profesor profesor) {
        final PersonaJDBCDAO personaJDBCDAO = new PersonaJDBCDAO(this
                .getConnection());
        personaJDBCDAO.persist(profesor);
        final PersistTemplate persistObjectTemplate = new PersistTemplate() {

            @Override
            public boolean isNew() {
                final ProfesorJDBCDAO profesorJDBCDAO = new ProfesorJDBCDAO(
                        ProfesorJDBCDAO.this.getConnection());
                return profesorJDBCDAO.findByIdProfesor(profesor.getId()) == null;
            }

            @Override
            public void addInsertParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, profesor.getId());
            }

            @Override
            public void addUpdateParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, profesor.getId());
                sentencia.setObject(2, profesor.getId());
            }

            @Override
            public void setIdObjeto(final Long nuevoId) {
                profesor.setId(nuevoId);
            }

        };
        persistObjectTemplate.persistObject(this.getConnection(),
                "INSERT INTO PROFESORES (ID_PERSONA) VALUES (?)",
                "UPDATE PROFESORES SET ID_PERSONA = ? WHERE ID_PERSONA = ?");
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#delete(curso.java.app.miniclase.pojosanotados.Profesor)
     */
    @SuppressWarnings("nls")
    public void remove(final Profesor profesor) {

        final DeleteTemplate deleteClases = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, profesor.getId());
            }

        };
        deleteClases.delete(this.getConnection(),
                "DELETE FROM PROFESORES_CLASE WHERE ID_PERSONA = ?");

        final DeleteTemplate deleteProfesor = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, profesor.getId());
            }

        };
        deleteProfesor.delete(this.getConnection(),
                "DELETE FROM PROFESORES WHERE ID_PERSONA = ?");

        final DeleteTemplate deletePersona = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, profesor.getId());
            }

        };
        deletePersona.delete(this.getConnection(),
                "DELETE FROM PERSONAS WHERE ID_PERSONA = ?");

    }

}
