/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jpa;

/**
 * @author Adolfo Sanz De Diego
 */
@SuppressWarnings("nls")
public enum UnidadDePersistencia {
    TEST("testclase"), REAL("clase");

    private final String nombre;

    private UnidadDePersistencia(final String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {

        return this.getNombre();
    }

}
