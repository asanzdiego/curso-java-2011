/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojos;

/**
 * @author Adolfo Sanz de Diego
 */
public class Persona {

    private int id;

    private String nombre;

    private String apellidos;

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
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * @return the nombre completo
     */
    @SuppressWarnings("nls")
    public String getNombreCompleto() {
        return this.nombre + " " + this.apellidos;
    }

    /**
     * @param nombre
     *            the nombre to set
     */
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * @param apellidos
     *            the apellidos to set
     */
    public void setApellidos(final String apellidos) {
        this.apellidos = apellidos;
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
        result = prime
                * result
                + ((this.getApellidos() == null) ? 0 : this.getApellidos()
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
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.getNombre() == null) {
            if (other.getNombre() != null) {
                return false;
            }
        } else if (!this.getNombre().equals(other.getNombre())) {
            return false;
        }
        if (this.getApellidos() == null) {
            if (other.getApellidos() != null) {
                return false;
            }
        } else if (!this.getApellidos().equals(other.getApellidos())) {
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
        builder.append("Persona [id=");
        builder.append(this.getId());
        builder.append(", nombre=");
        builder.append(this.getNombre());
        builder.append(", apellidos=");
        builder.append(this.getApellidos());
        builder.append("]");
        return builder.toString();
    }

}
