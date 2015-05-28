/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.proxies;

import java.sql.Connection;
import java.util.List;

import curso.java.app.miniclase.dao.jdbc.AlumnoJDBCDAO;
import curso.java.app.miniclase.dao.jdbc.ProfesorJDBCDAO;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class ClaseProxy extends Clase {

    private final Connection connection;

    /**
     * @param connection
     */
    public ClaseProxy(final Connection connection) {
        super();
        this.connection = connection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.pojosanotados.Clase#getAlumnos()
     */
    @Override
    public List<Alumno> getAlumnos() {
        if (super.getAlumnos() == null) {
            final AlumnoJDBCDAO profesorJDBCDAO = new AlumnoJDBCDAO(
                    this.connection);
            final List<Alumno> alumnos = profesorJDBCDAO.findByIdClase(this
                    .getId());
            this.setAlumnos(alumnos);
        }
        return super.getAlumnos();
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.pojosanotados.Clase#getProfesores()
     */
    @Override
    public List<Profesor> getProfesores() {
        if (super.getProfesores() == null) {
            final ProfesorJDBCDAO profesorJDBCDAO = new ProfesorJDBCDAO(
                    this.connection);
            final List<Profesor> profesores = profesorJDBCDAO
                    .findByIdClase(this.getId());
            this.setProfesores(profesores);
        }
        return super.getProfesores();
    }

}
