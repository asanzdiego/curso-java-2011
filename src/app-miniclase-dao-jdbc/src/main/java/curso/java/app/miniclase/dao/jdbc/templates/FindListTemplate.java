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
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adolfo Sanz De Diego
 */
public abstract class FindListTemplate<T> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("nls")
    public List<T> findList(final Connection connection, final String sql,
            final Mapeador<T> mapeador) {
        PreparedStatement sentencia = null;
        ResultSet cursor = null;
        final List<T> objetos = new ArrayList<T>();
        try {
            sentencia = connection.prepareStatement(sql);
            this.addParametros(sentencia);
            cursor = sentencia.executeQuery();
            while (cursor.next()) {
                final T objeto = mapeador.mapearObjeto(cursor);
                objetos.add(objeto);
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
        return objetos;
    }

    /**
     * Añade parametros a la sentencia.
     * 
     * @param sentencia
     * @throws SQLException
     */
    public abstract void addParametros(final PreparedStatement sentencia)
            throws SQLException;

}