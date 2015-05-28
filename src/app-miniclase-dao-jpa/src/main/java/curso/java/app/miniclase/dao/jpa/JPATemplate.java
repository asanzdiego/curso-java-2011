/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Adolfo Sanz De Diego
 */
class JPATemplate<T> {

    private final EntityManager manager;

    /**
     * @param manager
     */
    JPATemplate(final EntityManager manager) {
        this.manager = manager;
    }

    T findByPK(final Class<T> clase, final Long id) {
        final T objetoPersistente = this.manager.find(clase, id);
        return objetoPersistente;
    }

    @SuppressWarnings("unchecked")
    List<T> findByJPQL(final String jpql, final Object... params) {
        final Query query = this.manager.createQuery(jpql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i, params[0]);
        }
        final List<T> resultList = query.getResultList();
        return resultList;
    }

    void persist(final Object entity) {
        this.manager.getTransaction().begin();
        this.manager.persist(entity);
        this.manager.flush();
        this.manager.refresh(entity);
        this.manager.getTransaction().commit();
    }

    void remove(final Object entity) {
        this.manager.getTransaction().begin();
        this.manager.remove(entity);
        this.manager.flush();
        this.manager.getTransaction().commit();
    }
}
