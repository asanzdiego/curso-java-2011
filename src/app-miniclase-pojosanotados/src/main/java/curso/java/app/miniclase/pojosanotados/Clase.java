/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojosanotados;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * @author Adolfo Sanz De Diego
 */
@Entity
@Table(name = "CLASES")
@XStreamAlias("clase")
public class Clase {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLASE")
    @XStreamAsAttribute
    private Long id;

    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "DENOMINACION")
    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false, mappedBy = "clase", fetch = FetchType.LAZY)
    @XStreamImplicit(itemFieldName = "alumno")
    private List<Alumno> alumnos;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "PROFESORES_CLASE", joinColumns = { @JoinColumn(name = "ID_CLASE", referencedColumnName = "ID_CLASE") }, inverseJoinColumns = { @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA") })
    @XStreamImplicit(itemFieldName = "profesor")
    private List<Profesor> profesores;

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final Long id) {
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
    public List<Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * @param alumnos
     *            the alumnos to set
     */
    public void setAlumnos(final List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * @return the profesores
     */
    public List<Profesor> getProfesores() {
        return this.profesores;
    }

    /**
     * @param profesores
     *            the profesores to set
     */
    public void setProfesores(final List<Profesor> profesores) {
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
