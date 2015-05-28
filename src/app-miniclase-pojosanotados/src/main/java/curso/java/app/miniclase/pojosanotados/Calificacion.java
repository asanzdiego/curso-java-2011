/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojosanotados;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * @author Adolfo Sanz De Diego
 */
@Entity
@Table(name = "CALIFICACIONES")
@XStreamAlias("calificacion")
public class Calificacion {

    @Id
    @GeneratedValue
    @Column(name = "ID_CALIFICACION")
    @XStreamAsAttribute
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ALUMNO")
    @XStreamOmitField
    private Alumno alumno;

    @Column(name = "MODULO")
    private String modulo;

    @NotNull
    @Column(name = "FECHA")
    @XStreamOmitField
    private Date fecha;

    @Transient
    private String fechaFormateada;

    @Transient
    @XStreamOmitField
    private DateFormat formatoFecha;

    @NotNull
    @Column(name = "NOTA")
    private float nota;

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
     * @return the alumno
     */
    public Alumno getAlumno() {
        return this.alumno;
    }

    /**
     * @param alumno
     *            the alumno to set
     */
    public void setAlumno(final Alumno alumno) {
        this.alumno = alumno;
    }

    /**
     * @return the modulo
     */
    public String getModulo() {
        return this.modulo;
    }

    /**
     * @param modulo
     *            the modulo to set
     */
    public void setModulo(final String modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * @param fecha
     *            the fecha to set
     */
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
        this.fechaFormateada = this.getFormatoFecha().format(this.fecha);
    }

    /**
     * @return the fecha formateada
     */
    public String getFechaFormateada() {
        if (this.fechaFormateada != null) {
            return this.fechaFormateada;
        }
        if (this.fecha == null) {
            return null;
        }
        this.fechaFormateada = this.getFormatoFecha().format(this.fecha);
        return this.fechaFormateada;
    }

    /**
     * 
     * @param fechaFormateada
     */
    public void setFechaFormateada(final String fechaFormateada) {
        if (fechaFormateada == null) {
            this.fecha = null;
        }
        try {
            this.fecha = this.getFormatoFecha().parse(fechaFormateada);
            this.fechaFormateada = fechaFormateada;
        } catch (final ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the formatoFecha
     */
    public DateFormat getFormatoFecha() {
        if (this.formatoFecha == null) {
            this.formatoFecha = new SimpleDateFormat(Messages
                    .getString("formato-fecha")); //$NON-NLS-1$
        }
        return this.formatoFecha;
    }

    /**
     * @param formatoFecha
     *            the formatoFecha to set
     */
    public void setFormatoFecha(final DateFormat formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    /**
     * @return the nota
     */
    public float getNota() {
        return this.nota;
    }

    /**
     * @param nota
     *            the nota to set
     */
    public void setNota(final float nota) {
        this.nota = nota;
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
                + ((this.getAlumno() == null) ? 0 : this.getAlumno().hashCode());
        result = prime
                * result
                + ((this.getModulo() == null) ? 0 : this.getModulo().hashCode());
        result = prime * result
                + ((this.getFecha() == null) ? 0 : this.getFecha().hashCode());
        result = prime * result + new Float(this.getNota()).hashCode();
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
        if (!(obj instanceof Calificacion)) {
            return false;
        }
        final Calificacion other = (Calificacion) obj;
        if (this.getAlumno() == null) {
            if (other.getAlumno() != null) {
                return false;
            }
        } else if (!this.getAlumno().equals(other.getAlumno())) {
            return false;
        }
        if (this.getModulo() == null) {
            if (other.getModulo() != null) {
                return false;
            }
        } else if (!this.getModulo().equals(other.getModulo())) {
            return false;
        }
        if (this.getFechaFormateada() == null) {
            if (other.getFechaFormateada() != null) {
                return false;
            }
        } else if (!this.getFechaFormateada()
                .equals(other.getFechaFormateada())) {
            return false;
        }
        if (Float.floatToIntBits(this.getNota()) != Float.floatToIntBits(other
                .getNota())) {
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
        builder.append("Calificacion [id=");
        builder.append(this.getId());
        builder.append(", alumno=");
        builder.append(this.getAlumno() == null ? "null" : this.getAlumno()
                .getNombreCompleto());
        builder.append(", modulo=");
        builder.append(this.getModulo());
        builder.append(", fecha=");
        builder.append(this.getFechaFormateada());
        builder.append(", nota=");
        builder.append(this.getNota());
        builder.append("]");
        return builder.toString();
    }

}
