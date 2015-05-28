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
 * 
 * @depend "" - "" Clase
 * @depend "" - "" Modulo
 */
public class Profesor extends Persona {

    private int id;

    private Set<Clase> clases = new HashSet<Clase>();

    private Set<Modulo> modulos = new HashSet<Modulo>();

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
     * @return the clases
     */
    public Set<Clase> getClases() {
        return this.clases;
    }

    /**
     * @param clases
     *            the clases to set
     */
    public void setClases(final Set<Clase> clases) {
        this.clases = clases;
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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @SuppressWarnings("nls")
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Profesor [id=");
        builder.append(this.getId());
        builder.append(", nombre=");
        builder.append(this.getNombre());
        builder.append(", apellidos=");
        builder.append(this.getApellidos());
        builder.append("]");
        return builder.toString();
    }
}
