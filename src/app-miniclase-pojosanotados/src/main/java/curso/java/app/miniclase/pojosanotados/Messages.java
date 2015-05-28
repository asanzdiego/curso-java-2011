/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.pojosanotados;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author Adolfo Sanz De Diego
 * 
 */
public class Messages {

    private static final String BUNDLE_NAME = "curso.java.app.miniclase.pojosanotados.messages"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
            .getBundle(Messages.BUNDLE_NAME);

    private Messages() {
        // nothing here
    }

    public static String getString(final String key) {
        try {
            return Messages.RESOURCE_BUNDLE.getString(key);
        } catch (final MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
