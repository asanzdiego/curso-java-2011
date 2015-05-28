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
 * 
 * @depend "" - "" Modulo
 */
public class Alumno extends Persona {

    private int id;

    private Clase clase;

    private Set<Modulo> modulos = new HashSet<Modulo>();

    private Set<Calificacion> calificaciones = new HashSet<Calificacion>();

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
     * @return the clase
     */
    public Clase getClase() {
        return this.clase;
    }

    /**
     * @param clase
     *            the clase to set
     */
    public void setClase(final Clase clase) {
        this.clase = clase;
    }

    /**
     * @return the modulos
     */
    public Set<Modulo> getModulos() {
        return this.modulos;
    }

    /**
     * @param modulos
     *            the modulos to set
     */
    public void setModulos(final Set<Modulo> modulos) {
        this.modulos = modulos;
    }

    /**
     * @return the calificaciones
     */
    public Set<Calificacion> getCalificaciones() {
        return this.calificaciones;
    }

    /**
     * @param calificaciones
     *            the calificaciones to set
     */
    public void setCalificaciones(final Set<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
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
        result = prime * result
                + ((this.getClase() == null) ? 0 : this.getClase().hashCode());
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
        if (!(obj instanceof Alumno)) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (this.getClase() == null) {
            if (other.getClase() != null) {
                return false;
            }
        } else if (!this.getClase().equals(other.getClase())) {
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
        builder.append("Alumno [id=");
        builder.append(this.getId());
        builder.append(", nombre=");
        builder.append(this.getNombre());
        builder.append(", apellidos=");
        builder.append(this.getApellidos());
        builder.append("]");
        return builder.toString();
    }

}
