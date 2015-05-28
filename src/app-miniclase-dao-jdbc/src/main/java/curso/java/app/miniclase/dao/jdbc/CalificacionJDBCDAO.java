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
import java.util.Date;
import java.util.List;

import curso.java.app.miniclase.dao.CalificacionDAO;
import curso.java.app.miniclase.dao.jdbc.templates.DeleteTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindListTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindObjectTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.Mapeador;
import curso.java.app.miniclase.dao.jdbc.templates.PersistTemplate;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Calificacion;

/**
 * @author Adolfo Sanz De Diego
 */
public class CalificacionJDBCDAO extends AbstractJDBCDAO implements
        CalificacionDAO {

    private final Mapeador<Calificacion> mapeador = new Mapeador<Calificacion>() {

        @SuppressWarnings("nls")
        public Calificacion mapearObjeto(final ResultSet cursor)
                throws Exception {
            final Calificacion calificacion = new Calificacion();
            calificacion.setId((Long) cursor.getObject("ID_CALIFICACION"));
            calificacion.setFecha((Date) cursor.getObject("FECHA"));
            calificacion.setModulo(cursor.getString("MODULO"));
            calificacion.setNota(Float.parseFloat(cursor.getString("NOTA")));
            final Long idAlumno = (Long) cursor.getObject("ID_ALUMNO");
            final AlumnoJDBCDAO alumnoJDBCDAO = new AlumnoJDBCDAO(
                    CalificacionJDBCDAO.this.getConnection());
            final Alumno alumno = alumnoJDBCDAO.findByIdAlumno(idAlumno);
            calificacion.setAlumno(alumno);
            return calificacion;
        }

    };

    /**
     * @param connection
     */
    public CalificacionJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findAll()
     */
    @SuppressWarnings("nls")
    public List<Calificacion> findAll() {
        final FindListTemplate<Calificacion> findListTemplate = new FindListTemplate<Calificacion>() {

            @Override
            public void addParametros(final PreparedStatement sentencia) {
                // sin parametros
            }
        };

        final List<Calificacion> calificaciones = findListTemplate.findList(
                this.getConnection(), "SELECT * FROM CALIFICACIONES",
                this.mapeador);

        return calificaciones;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findByIdCalificacion(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public List<Calificacion> findByIdAlumno(final Long idAlumno) {
        final FindListTemplate<Calificacion> findListTemplate = new FindListTemplate<Calificacion>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idAlumno);
            }
        };

        final List<Calificacion> calificaciones = findListTemplate.findList(
                this.getConnection(), "SELECT * FROM CALIFICACIONES "
                        + "WHERE ID_ALUMNO = ?", this.mapeador);

        return calificaciones;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findByIdCalidicacion(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public Calificacion findByIdCalificacion(final Long idCalificacion) {
        final FindObjectTemplate<Calificacion> findObjectTemplate = new FindObjectTemplate<Calificacion>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idCalificacion);
            }
        };

        final Calificacion calificacion = findObjectTemplate.findObject(this
                .getConnection(), "SELECT * FROM CALIFICACIONES "
                + "WHERE ID_CALIFICACION = ?", this.mapeador);

        return calificacion;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Calificacion)
     */
    @SuppressWarnings("nls")
    public void persist(final Calificacion calificacion) {
        final PersistTemplate persistObjectTemplate = new PersistTemplate() {

            @Override
            protected boolean isNew() {
                final CalificacionJDBCDAO calificacionJDBCDAO = new CalificacionJDBCDAO(
                        CalificacionJDBCDAO.this.getConnection());
                return calificacionJDBCDAO.findByIdCalificacion(calificacion
                        .getId()) == null;
            }

            @Override
            public void addInsertParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, calificacion.getFecha());
                sentencia.setObject(2, calificacion.getModulo());
                sentencia.setObject(3, new Float(calificacion.getNota()));
                sentencia.setObject(4, calificacion.getAlumno() == null ? null
                        : calificacion.getAlumno().getId());
            }

            @Override
            public void addUpdateParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, calificacion.getFecha());
                sentencia.setObject(2, calificacion.getModulo());
                sentencia.setObject(3, new Float(calificacion.getNota()));
                sentencia.setObject(4, calificacion.getAlumno() == null ? null
                        : calificacion.getAlumno().getId());
                sentencia.setObject(5, calificacion.getId());
            }

            @Override
            public void setIdObjeto(final Long nuevoId) {
                calificacion.setId(nuevoId);
            }

        };
        persistObjectTemplate
                .persistObject(
                        this.getConnection(),
                        "INSERT INTO ALUMNOS (FECHA, MODULO, NOTA, ID_PERSONA) "
                                + "VALUES (?, ?, ?, ?)",
                        "UPDATE ALUMNOS "
                                + "SET FECHA = ?, MODULO = ?, NOTA = ?, ID_PERSONA = ? "
                                + "WHERE ID_CALIFICACION = ?");
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#delete(curso.java.app.miniclase.pojosanotados.Alumno)
     */
    @SuppressWarnings("nls")
    public void remove(final Calificacion calificacion) {
        final DeleteTemplate deleteCalificaciones = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, calificacion.getId());
            }

        };
        deleteCalificaciones.delete(this.getConnection(),
                "DELETE FROM CALIFICACIONES WHERE ID_ALUMNO = ?");
    }
}
