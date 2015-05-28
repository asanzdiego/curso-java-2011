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
import curso.java.app.miniclase.dao.CalificacionDAO;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Calificacion;

/**
 * @author Adolfo Sanz De Diego
 */
public class CalificacionJPADAO implements CalificacionDAO {

    private final EntityManager manager;

    /**
     * @param manager
     */
    CalificacionJPADAO(final EntityManager manager) {
        this.manager = manager;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findAll()
     */
    public List<Calificacion> findAll() {
        final JPATemplate<Calificacion> jpaTemplate = new JPATemplate<Calificacion>(
                this.manager);
        final List<Calificacion> calificaciones = jpaTemplate
                .findByJPQL("SELECT c FROM Calificacion c"); //$NON-NLS-1$
        return calificaciones;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findByIdAlumno(java.lang.Long)
     */
    public List<Calificacion> findByIdAlumno(final Long idAlumno) {
        final AlumnoDAO alumnoDAO = new AlumnoJPADAO(this.manager);
        final Alumno alumno = alumnoDAO.findByIdAlumno(idAlumno);
        final List<Calificacion> calificaciones = alumno.getCalificaciones();
        return calificaciones;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#findByIdCalidicacion(java.lang.Integer)
     */
    public Calificacion findByIdCalificacion(final Long idCalidicacion) {
        final JPATemplate<Calificacion> jpaTemplate = new JPATemplate<Calificacion>(
                this.manager);
        final Calificacion calificacion = jpaTemplate.findByPK(
                Calificacion.class, idCalidicacion);
        return calificacion;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Calificacion)
     */
    public void persist(final Calificacion calificacion) {
        final JPATemplate<Calificacion> jpaTemplate = new JPATemplate<Calificacion>(
                this.manager);
        jpaTemplate.persist(calificacion);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.CalificacionDAO#remove(curso.java.app.miniclase.pojosanotados.Calificacion)
     */
    public void remove(final Calificacion calificacion) {
        final JPATemplate<Calificacion> jpaTemplate = new JPATemplate<Calificacion>(
                this.manager);
        jpaTemplate.remove(calificacion);
    }

}
