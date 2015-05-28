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
public class Asignatura {

    private int id;

    private Clase clase;

    private Modulo modulo;

    private Profesor profesor;

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
     * @return the modulo
     */
    public Modulo getModulo() {
        return this.modulo;
    }

    /**
     * @param modulo
     *            the modulo to set
     */
    public void setModulo(final Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the profesor
     */
    public Profesor getProfesor() {
        return this.profesor;
    }

    /**
     * @param profesor
     *            the profesor to set
     */
    public void setProfesor(final Profesor profesor) {
        this.profesor = profesor;
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
        result = prime * result
                + ((this.getClase() == null) ? 0 : this.getClase().hashCode());
        result = prime
                * result
                + ((this.getModulo() == null) ? 0 : this.getModulo().hashCode());
        result = prime
                * result
                + ((this.getProfesor() == null) ? 0 : this.getProfesor()
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
        if (!(obj instanceof Asignatura)) {
            return false;
        }
        final Asignatura other = (Asignatura) obj;
        if (this.getClase() == null) {
            if (other.getClase() != null) {
                return false;
            }
        } else if (!this.getClase().equals(other.getClase())) {
            return false;
        }
        if (this.getModulo() == null) {
            if (other.getModulo() != null) {
                return false;
            }
        } else if (!this.getModulo().equals(other.getModulo())) {
            return false;
        }
        if (this.getProfesor() == null) {
            if (other.getProfesor() != null) {
                return false;
            }
        } else if (!this.getProfesor().equals(other.getProfesor())) {
            return false;
        }
        return true;
    }

}
