/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.templates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adolfo Sanz De Diego
 */
public abstract class DeleteTemplate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * @param connection
     * @param mapeador
     * @param objeto
     */
    @SuppressWarnings("nls")
    public void delete(final Connection connection, final String sqlDelete) {
        PreparedStatement sentencia = null;
        try {
            sentencia = connection.prepareStatement(sqlDelete);
            this.addDeleteParametros(sentencia);
            sentencia.executeUpdate();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (final Exception e) {
                this.log.warn("Error cerrando la sentenciar", e);
            }
        }
    }

    /**
     * @param sentencia
     * @param objeto
     * @throws SQLException
     */
    protected abstract void addDeleteParametros(
            final PreparedStatement sentencia) throws SQLException;
}