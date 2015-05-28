/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import curso.java.app.miniclase.dao.ProfesorDAO;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 */
public class ProfesorJPADAO implements ProfesorDAO {

    private final EntityManager manager;

    /**
     * @param manager
     */
    ProfesorJPADAO(final EntityManager manager) {
        this.manager = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#findAll()
     */
    public List<Profesor> findAll() {
        final JPATemplate<Profesor> jpaTemplate = new JPATemplate<Profesor>(
                this.manager);
        final List<Profesor> profesores = jpaTemplate
                .findByJPQL("SELECT p FROM Profesor p"); //$NON-NLS-1$
        return profesores;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#findByIdClase(java.lang.Long)
     */
    public List<Profesor> findByIdClase(final Long idClase) {
        final ClaseJPADAO claseJPADAO = new ClaseJPADAO(this.manager);
        final Clase clase = claseJPADAO.findByIdClase(idClase);
        final List<Profesor> profesores = clase.getProfesores();
        return profesores;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#findByIdProfesor(java.lang.Long)
     */
    public Profesor findByIdProfesor(final Long idProfesor) {
        final JPATemplate<Profesor> jpaTemplate = new JPATemplate<Profesor>(
                this.manager);
        final Profesor profesor = jpaTemplate.findByPK(Profesor.class,
                idProfesor);
        return profesor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Profesor)
     */
    public void persist(final Profesor profesor) {
        final JPATemplate<Profesor> jpaTemplate = new JPATemplate<Profesor>(
                this.manager);
        jpaTemplate.persist(profesor);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.ProfesorDAO#remove(curso.java.app.miniclase.pojosanotados.Profesor)
     */
    public void remove(final Profesor profesor) {
        final JPATemplate<Profesor> jpaTemplate = new JPATemplate<Profesor>(
                this.manager);
        jpaTemplate.remove(profesor);
    }

}
