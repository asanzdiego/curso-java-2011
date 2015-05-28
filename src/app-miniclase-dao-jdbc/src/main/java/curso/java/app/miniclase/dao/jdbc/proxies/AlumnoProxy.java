/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.proxies;

import java.sql.Connection;
import java.util.List;

import curso.java.app.miniclase.dao.jdbc.CalificacionJDBCDAO;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Calificacion;

/**
 * @author Adolfo Sanz De Diego
 */
public class AlumnoProxy extends Alumno {

    private final Connection connection;

    /**
     * @param connection
     */
    public AlumnoProxy(final Connection connection) {
        super();
        this.connection = connection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.pojosanotados.Alumno#getCalificaciones()
     */
    @Override
    public List<Calificacion> getCalificaciones() {
        if (super.getCalificaciones() == null) {
            final CalificacionJDBCDAO calificacionJDBCDAO = new CalificacionJDBCDAO(
                    this.connection);
            final List<Calificacion> calificaciones = calificacionJDBCDAO
                    .findByIdAlumno(this.getId());
            this.setCalificaciones(calificaciones);
        }
        return super.getCalificaciones();
    }
}
