/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
@SuppressWarnings("nls")
public enum ConexionBaseDeDatos {
    TEST("org.hsqldb.jdbcDriver",
            "jdbc:hsqldb:mem:testclase",
            "testclase",
            "testclase",
            "testclase"), // 
    REAL("com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/clase",
            "clase",
            "clase",
            "clase");

    private final String driver;
    private final String url;
    private final String user;
    private final String password;
    private final String esquema;

    /**
     * @param driver
     * @param url
     * @param user
     * @param password
     */
    private ConexionBaseDeDatos(final String driver, final String url,
            final String user, final String password, final String esquema) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
        this.esquema = esquema;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return this.driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return this.user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @return the esquema
     */
    public String getEsquema() {
        return this.esquema;
    }

}
