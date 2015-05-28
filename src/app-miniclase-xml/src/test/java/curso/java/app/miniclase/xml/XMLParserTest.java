/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.xml;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import junit.framework.TestCase;
import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Calificacion;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class XMLParserTest extends TestCase {

    private String xmlTest;

    private Clase claseTest;

    private Profesor profesorTest;

    private Alumno alumnoTest;

    private Calificacion calificaTest;

    /*
     * (non-Javadoc)
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @SuppressWarnings("nls")
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        final StringBuilder builder = new StringBuilder();
        builder.append("<clase id=\"1\">\n");
        builder.append("  <denominacion>1ASIR</denominacion>\n");
        builder.append("  <alumno id=\"1\">\n");
        builder.append("    <nombre>Pepito</nombre>\n");
        builder.append("    <apellidos>Palotes</apellidos>\n");
        builder.append("    <calificacion id=\"1\">\n");
        builder.append("      <modulo>ISO</modulo>\n");
        builder.append("      <fechaFormateada>2011/06/24</fechaFormateada>\n");
        builder.append("      <nota>4.5</nota>\n");
        builder.append("    </calificacion>\n");
        builder.append("  </alumno>\n");
        builder.append("  <profesor id=\"2\">\n");
        builder.append("    <nombre>Adolfo</nombre>\n");
        builder.append("    <apellidos>Sanz De Diego</apellidos>\n");
        builder.append("  </profesor>\n");
        builder.append("</clase>");
        this.xmlTest = builder.toString();

        final List<Profesor> profesoresTest = new ArrayList<Profesor>();
        final List<Alumno> alumnosTest = new ArrayList<Alumno>();
        final List<Calificacion> calificacionesTest = new ArrayList<Calificacion>();
        final List<Clase> clasesTest = new ArrayList<Clase>();

        this.claseTest = new Clase();
        this.claseTest.setId(new Long(1));
        this.claseTest.setDenominacion("1ASIR");
        this.claseTest.setAlumnos(alumnosTest);
        this.claseTest.setProfesores(profesoresTest);

        clasesTest.add(this.claseTest);

        this.profesorTest = new Profesor();
        this.profesorTest.setId(new Long(2));
        this.profesorTest.setNombre("Adolfo");
        this.profesorTest.setApellidos("Sanz De Diego");
        this.profesorTest.setClases(clasesTest);

        profesoresTest.add(this.profesorTest);

        this.alumnoTest = new Alumno();
        this.alumnoTest.setId(new Long(1));
        this.alumnoTest.setNombre("Pepito");
        this.alumnoTest.setApellidos("Palotes");
        this.alumnoTest.setCalificaciones(calificacionesTest);

        alumnosTest.add(this.alumnoTest);

        this.calificaTest = new Calificacion();
        this.calificaTest.setId(new Long(1));
        this.calificaTest.setFechaFormateada("2011/06/24");
        this.calificaTest.setModulo("ISO");
        this.calificaTest.setNota((float) 4.5);

        calificacionesTest.add(this.calificaTest);
    }

    /**
     * Test method for {@link curso.java.app.miniclase.xml.XMLParser#fromXML(java.lang.String)}.
     */
    public void testFromXML() {

        final XMLParser claseParser = new XMLParser();

        final Clase clase = (Clase) claseParser.fromXML(this.xmlTest);

        Assert.assertEquals(this.claseTest.getId(), clase.getId());
        Assert.assertEquals(this.claseTest, clase);

        final List<Profesor> profesores = clase.getProfesores();
        Assert.assertEquals(1, profesores.size());

        final Profesor profesor = profesores.get(0);
        Assert.assertEquals(this.profesorTest.getId(), profesor.getId());
        Assert.assertEquals(this.profesorTest, profesor);

        final List<Alumno> alumnos = clase.getAlumnos();
        Assert.assertEquals(1, alumnos.size());

        final Alumno alumno = alumnos.get(0);
        Assert.assertEquals(this.alumnoTest.getId(), alumno.getId());
        Assert.assertEquals(this.alumnoTest, alumno);

        final List<Calificacion> calificaciones = alumno.getCalificaciones();
        Assert.assertEquals(1, calificaciones.size());

        final Calificacion calificacion = calificaciones.get(0);
        Assert.assertEquals(this.calificaTest.getId(), calificacion.getId());
        Assert.assertEquals(this.calificaTest, calificacion);
    }

    /**
     * Test method for {@link curso.java.app.miniclase.xml.XMLParser#toXML(java.lang.Object)}.
     */
    public void testToXML() {

        final XMLParser claseParser = new XMLParser();

        final String xml = claseParser.toXML(this.claseTest);

        Assert.assertEquals(this.xmlTest, xml);
    }

}
