/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import curso.java.app.miniclase.dao.AlumnoDAO;
import curso.java.app.miniclase.dao.CalificacionDAO;
import curso.java.app.miniclase.dao.ClaseDAO;
import curso.java.app.miniclase.dao.DAOFactory;
import curso.java.app.miniclase.dao.ProfesorDAO;

/**
 * @author Adolfo Sanz De Diego
 */
public class JPADAOFactory implements DAOFactory {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final EntityManagerFactory managerFactory;

    private final EntityManager manager;

    /**
     * @param unidadDePersistencia
     */
    JPADAOFactory(final UnidadDePersistencia unidadDePersistencia) {
        this.managerFactory = Persistence
                .createEntityManagerFactory(unidadDePersistencia.getNombre());
        this.manager = this.managerFactory.createEntityManager();
    }

    public AlumnoDAO getAlumnoDAO() {
        return new AlumnoJPADAO(this.manager);
    }

    public CalificacionDAO getCalificacionDAO() {
        return new CalificacionJPADAO(this.manager);
    }

    public ClaseDAO getClaseDAO() {
        return new ClaseJPADAO(this.manager);
    }

    public ProfesorDAO getProfesorDAO() {
        return new ProfesorJPADAO(this.manager);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.DAOFactory#close()
     */
    public void close() {
        try {
            if (this.manager != null) {
                this.manager.close();
            }
        } catch (final Exception e) {
            this.log.error("Error cerrando el manager", e); //$NON-NLS-1$
        }
        try {
            if (this.managerFactory != null) {
                this.managerFactory.close();
            }
        } catch (final Exception e) {
            this.log.error("Error cerrando el factory", e); //$NON-NLS-1$
        }

    }
}
