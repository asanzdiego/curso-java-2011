/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import curso.java.app.miniclase.dao.AlumnoDAO;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Clase;

/**
 * @author Adolfo Sanz De Diego
 */
public class AlumnoJPADAO implements AlumnoDAO {

    private final EntityManager manager;

    /**
     * @param manager
     */
    AlumnoJPADAO(final EntityManager manager) {
        this.manager = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#findByIdClase(int)
     */
    public List<Alumno> findAll() {
        final JPATemplate<Alumno> jpaTemplate = new JPATemplate<Alumno>(
                this.manager);
        final List<Alumno> alumnos = jpaTemplate
                .findByJPQL("SELECT a FROM Alumno a"); //$NON-NLS-1$
        return alumnos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.AlumnoDAO#findByIdAlumno(java.lang.Long)
     */
    public Alumno findByIdAlumno(final Long idAlumno) {
        final JPATemplate<Alumno> jpaTemplate = new JPATemplate<Alumno>(
                this.manager);
        final Alumno alumno = jpaTemplate.findByPK(Alumno.class, idAlumno);
        return alumno;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.AlumnoDAO#findByIdClase(java.lang.Long)
     */
    public List<Alumno> findByIdClase(final Long idClase) {
        final ClaseJPADAO claseJPADAO = new ClaseJPADAO(this.manager);
        final Clase clase = claseJPADAO.findByIdClase(idClase);
        final List<Alumno> alumnos = clase.getAlumnos();
        return alumnos;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Alumno)
     */
    public void persist(final Alumno alumno) {
        final JPATemplate<Alumno> jpaTemplate = new JPATemplate<Alumno>(
                this.manager);
        jpaTemplate.persist(alumno);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.AlumnoDAO#delete(curso.java.app.miniclase.pojosanotados.Alumno)
     */
    public void remove(final Alumno alumno) {
        final JPATemplate<Alumno> jpaTemplate = new JPATemplate<Alumno>(
                this.manager);
        jpaTemplate.remove(alumno);
    }

}
