package curso.java.app.miniclase.xml;

import com.thoughtworks.xstream.XStream;

import curso.java.app.miniclase.pojosanotados.Alumno;
import curso.java.app.miniclase.pojosanotados.Calificacion;
import curso.java.app.miniclase.pojosanotados.Clase;
import curso.java.app.miniclase.pojosanotados.Profesor;

/**
 * Hello world!
 * 
 */
public class XMLParser {

    @SuppressWarnings("nls")
    public Object fromXML(final String xmlToParse) {
        final XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.alias("clase", Clase.class);
        xstream.alias("profesor", Profesor.class);
        xstream.alias("alumno", Alumno.class);
        xstream.alias("calificacion", Calificacion.class);
        // xstream.registerConverter(new XStreamDateConverter());
        final Object object = xstream.fromXML(xmlToParse);
        return object;
    }

    public String toXML(final Object objectToParse) {
        final XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        final String xml = xstream.toXML(objectToParse);
        return xml;
    }
}
