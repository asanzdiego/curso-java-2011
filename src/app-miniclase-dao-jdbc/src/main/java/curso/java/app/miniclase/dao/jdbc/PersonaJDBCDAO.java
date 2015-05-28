/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import curso.java.app.miniclase.dao.jdbc.templates.FindListTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.FindObjectTemplate;
import curso.java.app.miniclase.dao.jdbc.templates.Mapeador;
import curso.java.app.miniclase.dao.jdbc.templates.PersistTemplate;
import curso.java.app.miniclase.pojosanotados.Persona;

/**
 * @author Adolfo Sanz De Diego
 */
public class PersonaJDBCDAO extends AbstractJDBCDAO {

    private final Mapeador<Persona> mapeador = new Mapeador<Persona>() {

        @SuppressWarnings("nls")
        public Persona mapearObjeto(final ResultSet cursor) throws Exception {
            final Persona persona = new Persona();
            persona.setId((Long) cursor.getObject("ID_PERSONA"));
            persona.setNombre(cursor.getString("NOMBRE"));
            persona.setApellidos(cursor.getString("APELLIDOS"));
            return persona;
        }

    };

    /**
     * @param connection
     */
    public PersonaJDBCDAO(final Connection connection) {
        super(connection);
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.PersonaDAO#findAll()
     */
    @SuppressWarnings("nls")
    public List<Persona> findAll() {
        final FindListTemplate<Persona> findListTemplate = new FindListTemplate<Persona>() {

            @Override
            public void addParametros(final PreparedStatement sentencia) {
                // sin parametros
            }
        };

        final List<Persona> personas = findListTemplate.findList(this
                .getConnection(), "SELECT * FROM PERSONAS", this.mapeador);

        return personas;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * curso.java.app.miniclase.dao.PersonaDAO#findByIdPersona(java.lang.Long)
     */
    @SuppressWarnings("nls")
    public Persona findByIdPersona(final Long idPersona) {
        final FindObjectTemplate<Persona> findObjectTemplate = new FindObjectTemplate<Persona>() {

            @Override
            public void addParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, idPersona);
            }
        };

        final Persona persona = findObjectTemplate.findObject(this
                .getConnection(),
                "SELECT * FROM PERSONAS WHERE ID_PERSONA = ?", this.mapeador);

        return persona;
    }

    /*
     * (non-Javadoc)
     * 
     * @see curso.java.app.miniclase.dao.PersonaDAO#persist(
     * curso.java.app.miniclase.pojosanotados.Persona)
     */
    @SuppressWarnings("nls")
    public void persist(final Persona persona) {
        final PersistTemplate persistObjectTemplate = new PersistTemplate() {

            @Override
            protected boolean isNew() {
                final PersonaJDBCDAO personaJDBCDAO = new PersonaJDBCDAO(
                        PersonaJDBCDAO.this.getConnection());
                return personaJDBCDAO.findByIdPersona(persona.getId()) == null;
            }

            @Override
            public void addInsertParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, persona.getId());
                sentencia.setObject(2, persona.getNombre());
                sentencia.setObject(3, persona.getApellidos());
            }

            @Override
            public void addUpdateParametros(final PreparedStatement sentencia)
                    throws SQLException {
                sentencia.setObject(1, persona.getNombre());
                sentencia.setObject(2, persona.getApellidos());
                sentencia.setObject(3, persona.getId());
            }

            @Override
            public void setIdObjeto(final Long nuevoId) {
                persona.setId(nuevoId);
            }

        };
        persistObjectTemplate.persistObject(this.getConnection(),
                "INSERT INTO PERSONAS (ID_PERSONA, NOMBRE, APELLIDOS) "
                        + "VALUES (?, ?, ?)",
                "UPDATE PERSONAS SET NOMBRE = ?, APELLIDOS = ? "
                        + "WHERE ID_PERSONA = ?");
    }

}
