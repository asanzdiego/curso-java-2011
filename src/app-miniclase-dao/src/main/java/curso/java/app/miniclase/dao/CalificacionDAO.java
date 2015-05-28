/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

import java.util.List;

import curso.java.app.miniclase.pojosanotados.Calificacion;

/**
 * @author Adolfo Sanz De Diego
 */
public interface CalificacionDAO {

    public abstract void persist(final Calificacion calificacion);

    public abstract void remove(final Calificacion calificacion);

    public abstract List<Calificacion> findAll();

    public abstract Calificacion findByIdCalificacion(final Long idCalidicacion);

    public abstract List<Calificacion> findByIdAlumno(final Long idAlumno);
}
