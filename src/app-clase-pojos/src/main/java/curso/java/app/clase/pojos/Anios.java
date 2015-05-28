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
public class Anios {

    private int id;

    private int anioInicio;

    private int anioFin;

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
     * @return the anioInicio
     */
    public int getAnioInicio() {
        return this.anioInicio;
    }

    /**
     * @param anioInicio
     *            the anioInicio to set
     */
    public void setAnioInicio(final int anioInicio) {
        this.anioInicio = anioInicio;
    }

    /**
     * @return the anioFin
     */
    public int getAnioFin() {
        return this.anioFin;
    }

    /**
     * @param anioFin
     *            the anioFin to set
     */
    public void setAnioFin(final int anioFin) {
        this.anioFin = anioFin;
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
        result = prime * result + this.getAnioFin();
        result = prime * result + this.getAnioInicio();
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
        if (!(obj instanceof Anios)) {
            return false;
        }
        final Anios other = (Anios) obj;
        if (this.getAnioFin() != other.getAnioFin()) {
            return false;
        }
        if (this.getAnioInicio() != other.getAnioInicio()) {
            return false;
        }
        return true;
    }

    /**
     * @return anioInicio/anioFin
     */
    @SuppressWarnings("nls")
    public String getAnios() {
        final StringBuilder builder = new StringBuilder();
        builder.append(this.getAnioInicio());
        builder.append("/");
        builder.append(this.getAnioFin());
        return builder.toString();
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
        builder.append("Anios [id=");
        builder.append(this.getId());
        builder.append(", anioInicio=");
        builder.append(this.getAnioInicio());
        builder.append(", anioFin=");
        builder.append(this.getAnioFin());
        builder.append("]");
        return builder.toString();
    }

}
