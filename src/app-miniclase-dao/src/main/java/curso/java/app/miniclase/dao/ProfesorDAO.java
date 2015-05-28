/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

import java.util.List;

import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 */
public interface ProfesorDAO {

    public abstract void persist(final Profesor profesor);

    public abstract void remove(final Profesor profesor);

    public abstract List<Profesor> findAll();

    public abstract Profesor findByIdProfesor(final Long idProfesor);

    public abstract List<Profesor> findByIdClase(final Long idClase);
}
