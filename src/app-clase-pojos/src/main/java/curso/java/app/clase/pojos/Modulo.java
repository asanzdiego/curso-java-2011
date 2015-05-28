/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.clase.pojos;

/**
 * @author Adolfo Sanz De Diego
 */
public class Modulo {

    private int id;

    private String nombre;

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
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
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
                + ((this.getNombre() == null) ? 0 : this.getNombre().hashCode());
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
        if (!(obj instanceof Modulo)) {
            return false;
        }
        final Modulo other = (Modulo) obj;
        if (this.getNombre() == null) {
            if (other.getNombre() != null) {
                return false;
            }
        } else if (!this.getNombre().equals(other.getNombre())) {
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
        builder.append("Modulo [id=");
        builder.append(this.getId());
        builder.append(", nombre=");
        builder.append(this.getNombre());
        builder.append("]");
        return builder.toString();
    }

}
