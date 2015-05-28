/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import curso.java.app.miniclase.dao.ClaseDAO;
import curso.java.app.miniclase.dao.ProfesorDAO;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 */
public class ClaseJPADAO implements ClaseDAO {

    private final EntityManager manager;

    /**
     * @param manager
     */
    ClaseJPADAO(final EntityManager manager) {
        this.manager = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#findAll()
     */
    public List<Clase> findAll() {
        final JPATemplate<Clase> jpaTemplate = new JPATemplate<Clase>(
                this.manager);
        final List<Clase> clases = jpaTemplate
                .findByJPQL("SELECT c FROM Clase c"); //$NON-NLS-1$
        return clases;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#findByIdClase(java.lang.Long)
     */
    public Clase findByIdClase(final Long idClase) {
        final JPATemplate<Clase> jpaTemplate = new JPATemplate<Clase>(
                this.manager);
        final Clase clase = jpaTemplate.findByPK(Clase.class, idClase);
        return clase;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#findByIdProfesor(java.lang.Long)
     */
    public List<Clase> findByIdProfesor(final Long idProfesor) {
        final ProfesorDAO profesorDAO = new ProfesorJPADAO(this.manager);
        final Profesor profesor = profesorDAO.findByIdProfesor(idProfesor);
        final List<Clase> clases = profesor.getClases();
        return clases;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Clase)
     */
    public void persist(final Clase clase) {
        final JPATemplate<Clase> jpaTemplate = new JPATemplate<Clase>(
                this.manager);
        jpaTemplate.persist(clase);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ClaseDAO#remove(curso.java.app.miniclase.pojosanotados.Clase)
     */
    public void remove(final Clase clase) {
        final JPATemplate<Clase> jpaTemplate = new JPATemplate<Clase>(
                this.manager);
        jpaTemplate.remove(clase);
    }

}
