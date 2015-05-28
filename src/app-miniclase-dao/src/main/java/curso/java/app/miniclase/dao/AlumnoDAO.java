/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

import java.util.List;

import curso.java.app.miniclase.pojosanotados.Alumno;

/**
 * @author Adolfo Sanz De Diego
 */
public interface AlumnoDAO {

    public abstract void persist(final Alumno alumno);

    public abstract void remove(final Alumno alumno);

    public abstract List<Alumno> findAll();

    public abstract Alumno findByIdAlumno(final Long idAlumno);

    public abstract List<Alumno> findByIdClase(final Long idClase);
}
