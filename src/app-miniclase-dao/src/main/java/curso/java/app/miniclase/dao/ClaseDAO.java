/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

import java.util.List;

import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 */
public interface ClaseDAO {

    public abstract void persist(final Clase clase);

    public abstract void remove(final Clase clase);

    public abstract List<Clase> findAll();

    public abstract Clase findByIdClase(final Long idClase);

    public abstract List<Clase> findByIdProfesor(final Long idProfesor);
}
