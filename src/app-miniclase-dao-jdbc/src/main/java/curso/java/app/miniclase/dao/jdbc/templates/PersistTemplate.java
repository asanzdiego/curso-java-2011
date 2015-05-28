/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.templates;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adolfo Sanz De Diego
 */
public abstract class PersistTemplate {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void persistObject(final Connection connection,
            final String sqlInsert, final String sqlUpdate) {
        if (this.isNew()) {
            this.insert(connection, sqlInsert);
        } else {
            this.update(connection, sqlUpdate);
        }

    }

    /**
     * @return
     */
    protected abstract boolean isNew();

    /**
     * @param connection
     * @param mapeador
     * @param objeto
     */
    @SuppressWarnings("nls")
    private void insert(final Connection connection, final String sqlInsert) {
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        try {
            sentencia = connection.prepareStatement(sqlInsert,
                    Statement.RETURN_GENERATED_KEYS);
            this.addInsertParametros(sentencia);
            sentencia.executeUpdate();
            cursor = sentencia.getGeneratedKeys();
            if (cursor.next()) {
                final Long newId = (Long) cursor.getObject(1);
                this.setIdObjeto(newId);
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
                this.log.warn("Error cerrando la sentencia", e);
            }
        }
    }

    /**
     * @param sentencia
     * @param objeto
     * @throws SQLException
     */
    protected abstract void addInsertParametros(
            final PreparedStatement sentencia) throws SQLException;

    /**
     * @param objeto
     * @param newId
     */
    protected abstract void setIdObjeto(final Long newId);

    /**
     * @param connection
     * @param mapeador
     * @param objeto
     */
    @SuppressWarnings("nls")
    private void update(final Connection connection, final String sqlUpdate) {
        PreparedStatement sentencia = null;
        try {
            sentencia = connection.prepareStatement(sqlUpdate);
            this.addUpdateParametros(sentencia);
            sentencia.executeUpdate();
        } catch (final Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (sentencia != null) {
                    sentencia.close();
                }
            } catch (final Exception e) {
                this.log.warn("Error cerrando la sentencia", e);
            }
        }
    }

    /**
     * @param sentencia
     * @param objeto
     */
    protected abstract void addUpdateParametros(PreparedStatement sentencia)
            throws SQLException;

}