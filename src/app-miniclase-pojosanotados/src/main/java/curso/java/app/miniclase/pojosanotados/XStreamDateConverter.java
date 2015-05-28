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

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class XStreamDateConverter implements Converter {

    /*
     * (non-Javadoc)
     * 
     * @see com.thoughtworks.xstream.converters.Converter#marshal(java.lang.Object, com.thoughtworks.xstream.io.HierarchicalStreamWriter, com.thoughtworks.xstream.converters.MarshallingContext)
     */
    public void marshal(final Object source,
            final HierarchicalStreamWriter writer,
            final MarshallingContext context) {
        final Date date = (Date) source;
        final DateFormat formatoFecha = new SimpleDateFormat(Messages
                .getString("formato-fecha")); //$NON-NLS-1$
        final String fechaFormateada = formatoFecha.format(date);
        writer.setValue(fechaFormateada);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.thoughtworks.xstream.converters.Converter#unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader, com.thoughtworks.xstream.converters.UnmarshallingContext)
     */
    public Object unmarshal(final HierarchicalStreamReader reader,
            final UnmarshallingContext context) {
        final DateFormat formatoFecha = new SimpleDateFormat(Messages
                .getString("formato-fecha")); //$NON-NLS-1$
        final String fechaFormateada = reader.getValue();
        Date date = null;
        try {
            date = formatoFecha.parse(fechaFormateada);
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return date;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.thoughtworks.xstream.converters.ConverterMatcher#canConvert(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    public boolean canConvert(final Class type) {
        return type.equals(Date.class);

    }

}
