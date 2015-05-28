/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Adolfo Sanz De Diego
 */
public class Calificacion {

    private int id;

    private Alumno alumno;

    private Modulo modulo;

    private Evaluacion evaluacion;

    private Date fecha;

    private DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd"); //$NON-NLS-1$

    private float nota;

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
     * @return the evaluacion
     */
    public Evaluacion getEvaluacion() {
        return this.evaluacion;
    }

    /**
     * @param evaluacion
     *            the evaluacion to set
     */
    public void setEvaluacion(final Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * @return the fecha formateada
     */
    public String getFechaFormateada() {
        return this.formatoFecha.format(this.fecha);
    }

    /**
     * @param fecha
     *            the fecha to set
     */
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @param formatoFecha
     *            the formatoFecha to set
     */
    public void setFormatoFecha(final DateFormat formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    /**
     * @return the formatoFecha
     */
    public DateFormat getFormatoFecha() {
        return this.formatoFecha;
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
        result = prime
                * result
                + ((this.getEvaluacion() == null) ? 0 : this.getEvaluacion()
                        .hashCode());
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
        if (this.getEvaluacion() == null) {
            if (other.getEvaluacion() != null) {
                return false;
            }
        } else if (!this.getEvaluacion().equals(other.getEvaluacion())) {
            return false;
        }
        if (this.getFecha() == null) {
            if (other.getFecha() != null) {
                return false;
            }
        } else if (!this.getFecha().equals(other.getFecha())) {
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
        builder.append(this.getModulo() == null ? "null" : this.getModulo()
                .getNombre());
        builder.append(", evaluacion=");
        builder.append(this.getEvaluacion());
        builder.append(", fecha=");
        builder.append(this.getFechaFormateada());
        builder.append(", nota=");
        builder.append(this.getNota());
        builder.append("]");
        return builder.toString();
    }

}
