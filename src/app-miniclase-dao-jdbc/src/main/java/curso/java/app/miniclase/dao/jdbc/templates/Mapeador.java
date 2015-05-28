/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.templates;

import java.sql.ResultSet;

/**
 * @author Adolfo Sanz De Diego
 */
public interface Mapeador<T> {

    /**
     * @param cursor
     * @return Objeto mapeado
     */
    public abstract T mapearObjeto(final ResultSet cursor) throws Exception;
}