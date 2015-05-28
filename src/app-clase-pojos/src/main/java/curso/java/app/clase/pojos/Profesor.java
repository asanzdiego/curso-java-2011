/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.clase.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adolfo Sanz De Diego
 */
public class Profesor extends Persona {

    private int id;

    private Clase esTutor;

    private Set<Asignatura> asignaturas = new HashSet<Asignatura>();

    /**
     * @return the id
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    @Override
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the esTutor
     */
    public Clase getEsTutor() {
        return this.esTutor;
    }

    /**
     * @param esTutor
     *            the esTutor to set
     */
    public void setEsTutor(final Clase esTutor) {
        this.esTutor = esTutor;
    }

    /**
     * @return the asignaturas
     */
    public Set<Asignatura> getAsignaturas() {
        return this.asignaturas;
    }

    /**
     * @param asignaturas
     *            the asignaturas to set
     */
    public void setAsignaturas(final Set<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
                * result
                + ((this.getAsignaturas() == null) ? 0 : this.getAsignaturas()
                        .hashCode());
        result = prime
                * result
                + ((this.getEsTutor() == null) ? 0 : this.getEsTutor()
                        .hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Profesor)) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (this.getAsignaturas() == null) {
            if (other.getAsignaturas() != null) {
                return false;
            }
        } else if (!this.getAsignaturas().equals(other.getAsignaturas())) {
            return false;
        }
        if (this.getEsTutor() == null) {
            if (other.getEsTutor() != null) {
                return false;
            }
        } else if (!this.getEsTutor().equals(other.getEsTutor())) {
            return false;
        }
        return true;
    }

}
