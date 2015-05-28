/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc;

import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import curso.java.app.miniclase.dao.ClaseDAO;
import curso.java.app.miniclase.dao.ConexionBaseDeDatos;
import curso.java.app.miniclase.dao.DAOFactory;
import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class ClaseJDBCDAOTest extends TestCase {

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#tearDown()
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test method for
     * {@link curso.java.app.miniclase.dao.jdbc.ClaseJDBCDAO#persist(curso.java.app.miniclase.pojosanotados.Clase)}
     * .
     */
    public void testPersist() {
        try {
            final DAOFactory factory = new JDBCDAOFactory(ConexionBaseDeDatos.TEST);
            final ClaseDAO claseDAO = factory.getClaseDAO();

            final Clase clase = new Clase();
            clase.setDenominacion("PEPE");

            claseDAO.persist(clase);

            final List<Clase> clases = claseDAO.findAll();

            System.out.println(clases);
        } catch (final Exception e) {
            Assert.fail(e.toString());
            e.printStackTrace();
        }
    }

}
