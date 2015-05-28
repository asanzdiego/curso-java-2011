/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

/**
 * @author Adolfo Sanz De Diego
 */
public interface DAOFactory {

    public abstract AlumnoDAO getAlumnoDAO();

    public abstract CalificacionDAO getCalificacionDAO();

    public abstract ClaseDAO getClaseDAO();

    public abstract ProfesorDAO getProfesorDAO();

    public abstract void close();
}
