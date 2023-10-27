package granhotel80s.accesoADatos;

import java.awt.Dimension;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Conexion {

    public static final String URL = "jdbc:mariadb://localhost/";
    public static final String DB = "granhotel80s";
    public static final String USUARIO = "root";
    public static final String PASSWORD = "";
    public static Connection conexion = null;

    private Conexion() {
    }

    public static Connection getConnection() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD);

                mostrarMensajeDeBienvenida();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los drivers ");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos ");
            }
        }
        return conexion;
    }

    private static void mostrarMensajeDeBienvenida() {
        JDialog dialog = new JDialog();
        JOptionPane.showMessageDialog(dialog, "Bienvenido al Sistema de Reserva de Habitaciones y Gestión de Ventas del Gran Hotel 80s", "Sistema de Reserva de Habitaciones y Gestión de Ventas - Gran Hotel 80s", JOptionPane.INFORMATION_MESSAGE);
        dialog.setVisible(true);
    }
}