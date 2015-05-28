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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adolfo Sanz De Diego
 */
public class ProfesorClaseJDBCDAO extends AbstractJDBCDAO {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * @param connection
     */
    ProfesorClaseJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Profesor)
     */
    public void persist(final Long idProfesor, final Long idClase) {
        if (!this.exists(idProfesor, idClase)) {
            this.insert(idProfesor, idClase);
        }

    }

    /**
     * @param idProfesor
     * @param idClase
     * @return
     */
    @SuppressWarnings("nls")
    private boolean exists(final Long idProfesor, final Long idClase) {
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        try {
            sentencia = this
                    .getConnection()
                    .prepareStatement(
                            "SELECT * FROM PROFESORES_CLASE WHERE ID_PERSONA = ? AND ID_CLASE = ?");
            sentencia.setLong(1, idProfesor.longValue());
            sentencia.setLong(2, idClase.longValue());
            cursor = sentencia.executeQuery();
            if (cursor.next()) {
                return true;
            }
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (final Exception e) {
                this.log.warn("Error cerrando el cursor", e);
            }
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (final Exception e) {
                this.log.warn("Error cerrando el cursor", e);
            }
        }
        return false;
    }

    /**
     * @param idProfesor
     * @param idClase
     */
    @SuppressWarnings("nls")
    private void insert(final Long idProfesor, final Long idClase) {
        PreparedStatement sentencia = null;
        try {
            sentencia = this.getConnection().prepareStatement(
                    "INSERT INTO PROFESORES (ID_PERSONA, ID_CLAS) "
                            + "VALUES (?, ?)");
            sentencia.setLong(1, idProfesor.longValue());
            sentencia.setLong(2, idClase.longValue());
            sentencia.executeUpdate();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (final Exception e) {
                this.log.warn("Error cerrando el cursor", e);
            }
        }
    }
}
