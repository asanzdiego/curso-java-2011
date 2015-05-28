/**
 * <a href="http://www.viti.es/gnu/licenses/gpl.html">
 * Este código tiene una licencia GPL versión 3.0</a>
 * 
 * Autor: Adolfo Sanz De Diego (asanzdiego@gmail.com)
 */
package curso.java.app.miniclase.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.DatabaseSequenceFilter;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.FilteredDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlWriter;
import org.dbunit.operation.DatabaseOperation;

public class DBUnitUtils

{

    public static void generateXML(final ConexionBaseDeDatos conexion)
            throws SQLException {

        final Connection conection;

        try {
            // Connect to the database
            final Driver driver = (Driver) Class.forName(conexion.getDriver())
                    .newInstance();
            DriverManager.registerDriver(driver);
            conection = DriverManager.getConnection(conexion.getUrl(), conexion
                    .getUser(), conexion.getPassword());
            final IDatabaseConnection connection = new DatabaseConnection(
                    conection, conexion.getEsquema());

            final DatabaseSequenceFilter filter = new DatabaseSequenceFilter(
                    connection);
            final IDataSet datasetAll = new FilteredDataSet(filter, connection
                    .createDataSet());
            final QueryDataSet dataSet = new QueryDataSet(connection);

            final String[] listTableNames = filter.getTableNames(datasetAll);
            for (final String tableName : listTableNames) {
                // Specify the SQL to run to retrieve the data
                dataSet.addTable(tableName);
            }

            // Specify the location of the flat file(XML)
            final FlatXmlWriter datasetWriter = new FlatXmlWriter(
                    new FileOutputStream(conexion.getEsquema() + ".xml"));

            // Export the data
            datasetWriter.write(dataSet);

        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            conection.close();
        }
    }

    public static void createData(final String driverName, final String urlDB,
            final String userDB, final String passworDB, final String nameXML)
            throws SQLException {

        Connection conn = null;
        try {
            // Connect to the database
            DriverManager.registerDriver((Driver) Class.forName(driverName)
                    .newInstance());
            conn = DriverManager.getConnection(urlDB, userDB, passworDB);
            final IDatabaseConnection connection = new DatabaseConnection(conn);

            DatabaseOperation.INSERT.execute(connection, new FlatXmlDataSet(
                    new FileInputStream("C:\\" + nameXML + ".xml")));

        } catch (final Exception exc) {
            exc.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public static void deleteData(final String driverName, final String urlDB,
            final String userDB, final String passworDB, final String nameXML)
            throws SQLException {
        Connection conn = null;
        try {
            // Connect to the database
            DriverManager.registerDriver((Driver) Class.forName(driverName)
                    .newInstance());
            conn = DriverManager.getConnection(urlDB, userDB, passworDB);
            final IDatabaseConnection connection = new DatabaseConnection(conn);
            DatabaseOperation.DELETE.execute(connection, new FlatXmlDataSet(
                    new FileInputStream("C:\\" + nameXML + ".xml")));

        } catch (final Exception exc) {
            exc.printStackTrace();
        } finally {
            conn.close();
        }
    }

}
