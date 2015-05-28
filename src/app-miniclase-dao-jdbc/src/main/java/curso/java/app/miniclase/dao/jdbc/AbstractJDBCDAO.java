/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc;

import java.sql.Connection;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public abstract class AbstractJDBCDAO {

    private final Connection connection;

    public AbstractJDBCDAO(final Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return this.connection;
    }

}
