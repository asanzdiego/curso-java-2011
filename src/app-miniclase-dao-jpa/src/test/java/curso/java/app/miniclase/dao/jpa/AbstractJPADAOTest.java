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

import junit.framework.Assert;
import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Adolfo Sanz De Diego
 */
@SuppressWarnings("nls")
abstract class AbstractJPADAOTest extends TestCase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private EntityManagerFactory managerFactory;

    private EntityManager manager;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        try {
            this.log.info("Building JPA EntityManager for unit tests");
            this.managerFactory = Persistence
                    .createEntityManagerFactory(UnidadDePersistencia.TEST
                            .getNombre());
            this.manager = this.managerFactory.createEntityManager();
        } catch (final Exception ex) {
            ex.printStackTrace();
            Assert.fail("Exception during JPA EntityManager instanciation.");
        }
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        this.log.info("Shuting down Hibernate JPA layer.");
        try {
            if (this.manager != null) {
                this.manager.close();
            }
            if (this.managerFactory != null) {
                this.managerFactory.close();
            }
        } catch (final Exception e) {
            this.log.error("Error shuting down Hibernate JPA layer.", e);
        }
    }

    /**
     * @return the manager
     */
    public EntityManager getManager() {
        return this.manager;
    }

    /**
     * @param manager
     *            the manager to set
     */
    public void setManager(final EntityManager manager) {
        this.manager = manager;
    }

}
