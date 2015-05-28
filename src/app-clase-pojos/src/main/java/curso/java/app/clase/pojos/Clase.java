/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.clase.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Adolfo Sanz De Diego
 */
public class Clase {

    private int id;

    private Ciclo ciclo;

    private Curso curso;

    private Turno turno;

    private Profesor tutor;

    private Anios anios;

    private Set<Alumno> alumnos = new HashSet<Alumno>();

    private Set<Profesor> profesores = new HashSet<Profesor>();

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
     * @return the ciclo
     */
    public Ciclo getCiclo() {
        return this.ciclo;
    }

    /**
     * @param ciclo
     *            the ciclo to set
     */
    public void setCiclo(final Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    /**
     * @return the curso
     */
    public Curso getCurso() {
        return this.curso;
    }

    /**
     * @param curso
     *            the curso to set
     */
    public void setCurso(final Curso curso) {
        this.curso = curso;
    }

    /**
     * @return the turno
     */
    public Turno getTurno() {
        return this.turno;
    }

    /**
     * @param turno
     *            the turno to set
     */
    public void setTurno(final Turno turno) {
        this.turno = turno;
    }

    /**
     * @return the tutor
     */
    public Profesor getTutor() {
        return this.tutor;
    }

    /**
     * @param tutor
     *            the tutor to set
     */
    public void setTutor(final Profesor tutor) {
        this.tutor = tutor;
    }

    /**
     * @return the anios
     */
    public Anios getAnios() {
        return this.anios;
    }

    /**
     * @param anios
     *            the anios to set
     */
    public void setAnios(final Anios anios) {
        this.anios = anios;
    }

    /**
     * @return the alumnos
     */
    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * @param alumnos
     *            the alumnos to set
     */
    public void setAlumnos(final Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * @return the profesores
     */
    public Set<Profesor> getProfesores() {
        return this.profesores;
    }

    /**
     * @param profesores
     *            the profesores to set
     */
    public void setProfesores(final Set<Profesor> profesores) {
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
        result = prime * result
                + ((this.getCiclo() == null) ? 0 : this.getCiclo().hashCode());
        result = prime * result
                + ((this.getCurso() == null) ? 0 : this.getCurso().hashCode());
        result = prime * result
                + ((this.getTurno() == null) ? 0 : this.getTurno().hashCode());
        result = prime * result
                + ((this.getTutor() == null) ? 0 : this.getTutor().hashCode());
        result = prime * result
                + ((this.getAnios() == null) ? 0 : this.getAnios().hashCode());
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
        if (this.getCiclo() == null) {
            if (other.getCiclo() != null) {
                return false;
            }
        } else if (!this.getCiclo().equals(other.getCiclo())) {
            return false;
        }
        if (this.getCurso() == null) {
            if (other.getCurso() != null) {
                return false;
            }
        } else if (!this.getCurso().equals(other.getCurso())) {
            return false;
        }
        if (this.getTurno() == null) {
            if (other.getTurno() != null) {
                return false;
            }
        } else if (!this.getTurno().equals(other.getTurno())) {
            return false;
        }
        if (this.getTutor() == null) {
            if (other.getTutor() != null) {
                return false;
            }
        } else if (!this.getTutor().equals(other.getTutor())) {
            return false;
        }
        if (this.getAnios() == null) {
            if (other.getAnios() != null) {
                return false;
            }
        } else if (!this.getAnios().equals(other.getAnios())) {
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
        builder.append(", ciclo=");
        builder.append(this.getCiclo());
        builder.append(", curso=");
        builder.append(this.getCurso());
        builder.append(", turno=");
        builder.append(this.getTurno());
        builder.append(", tutor=");
        builder.append(this.getTutor() == null ? "null" : this.getTutor()
                .getNombreCompleto());
        builder.append(", anios=");
        builder.append(this.getAnios() == null ? "null" : this.getAnios());
        builder.append("]");
        return builder.toString();
    }
}
