/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc.proxies;

import java.sql.Connection;
import java.util.List;

import curso.java.app.miniclase.dao.jdbc.ClaseJDBCDAO;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 */
public class ProfesorProxy extends Profesor {

    private final Connection connection;

    /**
     * @param connection
     */
    public ProfesorProxy(final Connection connection) {
        super();
        this.connection = connection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.pojosanotados.Alumno#getCalificaciones()
     */
    @Override
    public List<Clase> getClases() {
        if (super.getClases() == null) {
            final ClaseJDBCDAO claseJDBCDAO = new ClaseJDBCDAO(this.connection);
            final List<Clase> clases = claseJDBCDAO.findByIdProfesor(this
                    .getId());
            this.setClases(clases);
        }
        return super.getClases();
    }
}
