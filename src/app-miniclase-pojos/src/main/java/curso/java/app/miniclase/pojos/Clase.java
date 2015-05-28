/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adolfo Sanz De Diego
 */
public class Clase {

    private int id;

    private String denominacion;

    private Set<Alumno> alumnos = new HashSet<Alumno>();

    private Set<Profesor> profesores = new HashSet<Profesor>();

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * @return the denominacion
     */
    public String getDenominacion() {
        return this.denominacion;
    }

    /**
     * @param denominacion
     *            the denominacion to set
     */
    public void setDenominacion(final String denominacion) {
        this.denominacion = denominacion;
    }

    /**
     * @return the alumnos
     */
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * @param alumnos
     *            the alumnos to set
     */
    public void setAlumnos(final Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * @return the profesores
     */
    public Set<Profesor> getProfesores() {
        return this.profesores;
    }

    /**
     * @param profesores
     *            the profesores to set
     */
    public void setProfesores(final Set<Profesor> profesores) {
        this.profesores = profesores;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime
                * result
                + ((this.getDenominacion() == null) ? 0 : this
                        .getDenominacion().hashCode());
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
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Clase)) {
            return false;
        }
        final Clase other = (Clase) obj;
        if (this.getDenominacion() == null) {
            if (other.getDenominacion() != null) {
                return false;
            }
        } else if (!this.getDenominacion().equals(other.getDenominacion())) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Clase [id=");
        builder.append(this.getId());
        builder.append(", denominacion=");
        builder.append(this.getDenominacion());
        builder.append("]");
        return builder.toString();
    }
}
