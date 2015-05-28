/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import java.util.List;

import junit.framework.Assert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import curso.java.app.miniclase.dao.AlumnoDAO;
import curso.java.app.miniclase.dao.DAOFactory;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class AlumnoJPADAOTest extends AbstractJPADAOTest {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Test method for {@link curso.java.app.miniclase.dao.jpa.AlumnoJPADAO#findByIdAlumno(int)}
     */
    @SuppressWarnings("nls")
    public void testFindByIdAlumno() {

        final Clase clase = new Clase();
        clase.setDenominacion("1ASIRV");

        final DAOFactory factory = new JPADAOFactory(UnidadDePersistencia.REAL);

        // factory.getClaseDAO().persist(clase);

        final Alumno alumno1 = new Alumno();
        alumno1.setNombre("Pepito");
        alumno1.setApellidos("Palotes");
        alumno1.setClase(clase);

        final AlumnoDAO alumnoDAO = factory.getAlumnoDAO();

        // alumnoDAO.persist(alumno1);

        final List<Alumno> alumnos = alumnoDAO.findAll();

        Assert.assertEquals(alumno1, alumnos.get(0));

        final Alumno alumno2 = alumnoDAO.findByIdAlumno(alumno1.getId());

        Assert.assertEquals(alumno1, alumno2);

    }
}
