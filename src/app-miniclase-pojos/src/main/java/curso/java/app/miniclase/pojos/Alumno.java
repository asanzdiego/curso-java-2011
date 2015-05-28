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
public class Alumno extends Persona {

    private int id;

    private Clase clase;

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
