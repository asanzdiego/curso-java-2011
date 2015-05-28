/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import curso.java.app.miniclase.dao.AlumnoDAO;
import curso.java.app.miniclase.dao.CalificacionDAO;
import curso.java.app.miniclase.dao.ClaseDAO;
import curso.java.app.miniclase.dao.ConexionBaseDeDatos;
import curso.java.app.miniclase.dao.DAOFactory;
import curso.java.app.miniclase.dao.ProfesorDAO;

/**
 * @author Adolfo Sanz De Diego
 */
public class JDBCDAOFactory implements DAOFactory {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final Connection connection;

    public JDBCDAOFactory(final ConexionBaseDeDatos conexionBaseDeDatos)
            throws Exception {
        // Registramos la clase con la que nos vamos a conectar
        Class.forName(conexionBaseDeDatos.getDriver());

        // Establecemos una conexión con la base de datos
        this.connection = DriverManager.getConnection(conexionBaseDeDatos
                .getUrl(), conexionBaseDeDatos.getUser(), conexionBaseDeDatos
                .getPassword());

        // Si no queremos que se ejecute el commit automáticamente
        this.connection.setAutoCommit(false);
    }

    public AlumnoDAO getAlumnoDAO() {
        return new AlumnoJDBCDAO(this.connection);
    }

    public CalificacionDAO getCalificacionDAO() {
        return new CalificacionJDBCDAO(this.connection);
    }

    public ClaseDAO getClaseDAO() {
        return new ClaseJDBCDAO(this.connection);
    }

    public ProfesorDAO getProfesorDAO() {
        return new ProfesorJDBCDAO(this.connection);
    }

    @SuppressWarnings("nls")
    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (final Exception e) {
            this.log.warn("Error cerrando la conexion", e);
        }
    }
}
