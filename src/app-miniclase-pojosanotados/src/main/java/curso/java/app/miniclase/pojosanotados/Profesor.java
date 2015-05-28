/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojosanotados;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author Adolfo Sanz De Diego
 * 
 * @depend "" - "" Clase
 */
@Entity
@Table(name = "PROFESORES")
@XStreamAlias("profesor")
public class Profesor extends Persona {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PROFESORES_CLASE", joinColumns = { @JoinColumn(name = "ID_PROFESOR", referencedColumnName = "ID_PERSONA") }, inverseJoinColumns = { @JoinColumn(name = "ID_CLASE", referencedColumnName = "ID_CLASE") })
    @XStreamOmitField
    private List<Clase> clases;

    /**
     * @return the clases
     */
    public List<Clase> getClases() {
        return this.clases;
    }

    /**
     * @param clases
     *            the clases to set
     */
    public void setClases(final List<Clase> clases) {
        this.clases = clases;
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
