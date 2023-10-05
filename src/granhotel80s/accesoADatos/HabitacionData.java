
package granhotel80s.accesoADatos;

import granhotel80s.entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class HabitacionData {
    
    private Connection con = null;
    
    public HabitacionData() {
        
         con = Conexion.getConnection();
         
}
    
    public void guardarHabitacion(Habitacion habitacion) {
        String sql = "INSERT INTO habitacion(categoria, Piso, nroHabitacion, estado) "
                + " VALUES (? , ? , ? , ?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, habitacion.getCategoria());
            ps.setInt(2, habitacion.getPiso());
            ps.setInt(3, habitacion.getNroHabitacion());
            ps.setBoolean(4, habitacion.isEstado());            
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
    
    public void modificarHabitacion (Habitacion habitacion) {
        String sql = "UPDATE habitacion SET categoria = ? ,Piso = ?, nroHabitacion = ? WHERE idHabitacion = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, habitacion.getCategoria());
            ps.setInt(2, habitacion.getPiso());
            ps.setInt(3, habitacion.getNroHabitacion());
            ps.setInt(3, habitacion.getIdHabitacion());
            
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
    
    
    
}
