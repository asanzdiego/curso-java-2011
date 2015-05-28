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

import curso.java.app.miniclase.dao.ClaseDAO;
import curso.java.app.miniclase.dao.jdbc.proxies.ClaseProxy;
import curso.java.app.miniclase.dao.jdbc.templates.DeleteTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindListTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindObjectTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.Mapeador;
import curso.java.app.miniclase.dao.jdbc.templates.PersistTemplate;
import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 */
public class ClaseJDBCDAO extends AbstractJDBCDAO implements ClaseDAO {

    private final Mapeador<Clase> mapeador = new Mapeador<Clase>() {

        @SuppressWarnings("nls")
        public Clase mapearObjeto(final ResultSet cursor) throws Exception {
            final Clase clase = new ClaseProxy(ClaseJDBCDAO.this
                    .getConnection());
            clase.setDenominacion(cursor.getString("DENOMINACION"));
            return clase;
        }

    };

    /**
     * @param connection
     */
    public ClaseJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#findAll()
     */
    @SuppressWarnings("nls")
    public List<Clase> findAll() {
        final FindListTemplate<Clase> findListTemplate = new FindListTemplate<Clase>() {

            @Override
            public void addParametros(final PreparedStatement sentencia) {
                // sin parametros
            }
        };

        final List<Clase> clases = findListTemplate.findList(this
                .getConnection(), "SELECT * FROM CLASES", this.mapeador);

        return clases;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.ClaseDAO#findByIdClase(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public Clase findByIdClase(final Long idClase) {
        final FindObjectTemplate<Clase> findObjectTemplate = new FindObjectTemplate<Clase>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idClase);
            }
        };

        final Clase clase = findObjectTemplate.findObject(this.getConnection(),
                "SELECT * FROM CLASES WHERE ID_CLASE = ?", this.mapeador);

        return clase;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#findByIdProfesor(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public List<Clase> findByIdProfesor(final Long idProfesor) {
        final FindListTemplate<Clase> findListTemplate = new FindListTemplate<Clase>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idProfesor);
            }
        };

        final List<Clase> clases = findListTemplate.findList(this
                .getConnection(), "SELECT c.* "
                + "FROM CLASES c, PROFESORES_CLASE pc "
                + "WHERE c.ID_CLASE = pc.ID_CLASE AND pc.ID_PERSONA = ?",
                this.mapeador);

        return clases;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Clase)
     */
    @SuppressWarnings("nls")
    public void persist(final Clase clase) {
        final PersistTemplate persistObjectTemplate = new PersistTemplate() {

            @Override
            protected boolean isNew() {
                final ClaseJDBCDAO claseJDBCDAO = new ClaseJDBCDAO(
                        ClaseJDBCDAO.this.getConnection());
                return claseJDBCDAO.findByIdClase(clase.getId()) == null;
            }

            @Override
            public void addInsertParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, clase.getDenominacion());
            }

            @Override
            public void addUpdateParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, clase.getDenominacion());
                sentencia.setObject(2, clase.getId());
            }

            @Override
            public void setIdObjeto(final Long nuevoId) {
                clase.setId(nuevoId);
            }
        };
        persistObjectTemplate.persistObject(this.getConnection(),
                "INSERT INTO CLASES (DENOMINACION) VALUES (?)",
                "UPDATE CLASES SET DENOMINACION = ? WHERE ID_CLASE = ?");
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#delete(curso.java.app.miniclase.pojosanotados.Clase)
     */
    @SuppressWarnings("nls")
    public void remove(final Clase clase) {

        final DeleteTemplate deleteAlumnos = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, clase.getId());
            }

        };
        deleteAlumnos.delete(this.getConnection(),
                "UPDATE CLASES SET ID_CLASE = NULL WHERE ID_CLASE = ?");

        final DeleteTemplate deleteProfesores = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, clase.getId());
            }

        };
        deleteProfesores.delete(this.getConnection(),
                "DELETE FROM PROFESORES_CLASE WHERE ID_CLASE = ?");

        final DeleteTemplate deleteClases = new DeleteTemplate() {

            @Override
            public void addDeleteParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, clase.getId());
            }

        };
        deleteClases.delete(this.getConnection(),
                "DELETE FROM CLASES WHERE ID_CLASE = ?");
    }

}
