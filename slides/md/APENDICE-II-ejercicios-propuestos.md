% APENDICE II - Ejercicios propuestos
% Adolfo Sanz De Diego
% Junio de 2011

# Día 1

- **U.T.  1 - Introducción a Java.**
    - Teoría.
- **U.T.  2 - Instalación y configuración del entorno.**
    - Teoría.
- **U.T.  3 - Sintaxis del lenguaje.**
    - Realizar un pequeño programa en Java que lea varios parámetros
    desde línea de comandos, convierta dichos parámetros,
    controlando las excepciones.

# Día 2
- **U.T.  4 - Clases y objetos.**
    - Ralizar la clases (en un proyecto Maven):
        - Modulo (nombre)
        - Calificacion (nota, fecha y Modulo)
- **U.T.  5 - Utilización avanzada de clases.**
    - Ralizar/modificar las clases:
        - Persona (nombre y apellidos)
        - Alumno (toString)
        - Calificacion (nota, fecha, formatoFecha, Modulo, Evaluacion y Alumno)
        - Evaluacion (enum)

# Día 3

- **U.T.  6 - Estructuras de datos.**
    - Ralizar/modificar las clases (hashCode, equals, toString):
        - Clase (denominacion, alumnos, profesores)
        - Persona (nombre y apellidos)
        - Alumno (clase, calificaciones)
        - Profesor (clases, modulos)
- **U.T.  7 - Documentación del código.**
    - JavaDoc (con Maven)

# Día 4

- **U.T.  8 - Documentación de las aplicaciones.**
    - UMLGraph (con Maven)
- **U.T.  9 - Patrones de diseño.**
    - DAOFactory (jdbc y jpa).
    - Proxy para:
        - Clase (getAlumnos y getProfesores)
        - Alumno (getCalificaciones)
        - Profesor (getClases, getModulos)

# Día 5

- **U.T. 10 - Desarrollo guiado por pruebas.**
    - Implementar los test de los DAOs.
- **U.T. 11 - Desarrollo de aplicaciones en el mundo real.**
    - maven
    - sonar
    - checkstyle, PMD, findbugs (maven, sonar y Eclipse)

# Día 6

- **U.T. 12 - Lectura y escritura de información estándar.**
    - Implementar una interfaz mediante linea de comandos.
    - Leer el contenido de un fichero txt (lo utilizaré pare leer un fichero sql)
- **U.T. 13 - Lectura y escritura de ficheros.**
    - Leer un fichero de propiedades
    - XML to POJO
    - POJO to XML

# Día 7

- **U.T. 14 - Trabajo con bases de datos mediante JDBC.**
    - Implementar JDBCDAOFactory
- **U.T. 15 - Persistencia de objetos con JPA.**
    - Implementar JPADAOFactory
