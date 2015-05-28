package curso.java.ejemplos.clase;

/**
 * Hello world!
 */
public class App {
    public static void main(final String[] args) {
        System.out.println("Empezando...");
        double suma = 0;
        for (int i = 0; i < args.length; i++) {
            final String parametro = args[i].replace(',', '.');
            final double numero;
            try {
                numero = Double.parseDouble(parametro);
                suma += numero;
                System.out.println("Parametro" + i + "=" + numero);
            } catch (final Exception e) {
                System.err.println("Error en parametro" + i + "=" + parametro
                        + " " + e.toString());
                e.printStackTrace();
            }

        }
        System.out.println("Terminando...");
    }
}
