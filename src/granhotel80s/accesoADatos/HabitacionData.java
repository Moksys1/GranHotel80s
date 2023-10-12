
package granhotel80s.accesoADatos;

import granhotel80s.entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class HabitacionData {
    
    private Connection con = null;
    
    public HabitacionData() {
        
         con = Conexion.getConnection();
         
}
    
    public void guardarHabitacion(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion(idTipoHabitacion, categoria, Piso, nroHabitacion, estado) "
                + " VALUES (?, ? , ? , ? , ?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, habitacion.getIdTipoHabitacion());
            ps.setString(2, habitacion.getCategoria());
            ps.setInt(3, habitacion.getPiso());
            ps.setInt(4, habitacion.getNroHabitacion());
            ps.setBoolean(5, habitacion.isEstado());            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                habitacion.setIdHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Habitacion añadida con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion");

        }
    }
    
    public void modificarHabitacion(Habitacion habitacion) {
        String sql = "UPDATE habitacion SET idTipoHabitacion = ?,categoria = ? ,Piso = ?, nroHabitacion = ? WHERE idHabitacion = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, habitacion.getIdTipoHabitacion());
            ps.setString(2, habitacion.getCategoria());
            ps.setInt(3, habitacion.getPiso());
            ps.setInt(4, habitacion.getNroHabitacion());
            ps.setInt(5, habitacion.getIdHabitacion());
            
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Habitacion modificada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "La habitacion buscada no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion");
        }
    }
    
    public void eliminarHabitacion(int id) {
        String sql = "UPDATE habitacion SET estado = 0 WHERE idHabitacion = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Habitacion eliminada correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Habitacion.");
        }
    
    
    
    }
    
    public List<Habitacion> obtenerHabitaciones() {

        ArrayList<Habitacion> habitaciones = new ArrayList<>();

        String sql = "SELECT * FROM habitacion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Habitacion habi = new Habitacion();
                habi.setIdHabitacion(rs.getInt("idHabitacion"));
                habi.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                habi.setCategoria(rs.getString("categoria"));
                habi.setPiso(rs.getInt("Piso"));
                habi.setNroHabitacion(rs.getInt("nroHabitacion"));
                habi.setEstado(rs.getBoolean("estado"));
                habitaciones.add(habi);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion.");
        }

        return habitaciones;

    }
    
    public List<Habitacion> obtenerHabitacionesDesopupadas() {

        ArrayList<Habitacion> habitDesocupadas = new ArrayList<>();

        String sql = "SELECT * FROM habitacion WHERE estado = 1 ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Habitacion habi = new Habitacion();
                habi.setIdHabitacion(rs.getInt("idHabitacion"));
                habi.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                habi.setCategoria(rs.getString("categoria"));
                habi.setPiso(rs.getInt("Piso"));
                habi.setNroHabitacion(rs.getInt("nroHabitacion"));
                habitDesocupadas.add(habi);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion.");
        }

        return habitDesocupadas;

    }
    
    public List<Habitacion> obtenerHabitacionesOcupadas() {

        ArrayList<Habitacion> habitDesocupadas = new ArrayList<>();

        String sql = "SELECT * FROM habitacion WHERE estado = 0 ";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Habitacion habi = new Habitacion();
                habi.setIdHabitacion(rs.getInt("idHabitacion"));
                habi.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                habi.setCategoria(rs.getString("categoria"));
                habi.setPiso(rs.getInt("Piso"));
                habi.setNroHabitacion(rs.getInt("nroHabitacion"));
                habitDesocupadas.add(habi);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion.");
        }

        return habitDesocupadas;

    }
    
}
