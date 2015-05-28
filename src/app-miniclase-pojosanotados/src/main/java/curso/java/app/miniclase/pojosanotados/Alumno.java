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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author Adolfo Sanz De Diego
 */
@Entity
@Table(name = "ALUMNOS")
@XStreamAlias("alumno")
public class Alumno extends Persona {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLASE")
    @XStreamOmitField
    private Clase clase;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno", fetch = FetchType.LAZY)
    @XStreamImplicit(itemFieldName = "calificacion")
    private List<Calificacion> calificaciones;

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
    public List<Calificacion> getCalificaciones() {
        return this.calificaciones;
    }

    /**
     * @param calificaciones
     *            the calificaciones to set
     */
    public void setCalificaciones(final List<Calificacion> calificaciones) {
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
