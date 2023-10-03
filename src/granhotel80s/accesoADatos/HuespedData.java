package granhotel80s.accesoADatos;

import granhotel80s.entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class HuespedData {
    
    private Connection con = null;
    
    public HuespedData() {
        
         con = Conexion.getConnection();
         
}
   
    public void guardarHuesped(Huesped huesped) {
        String sql = "INSERT INTO huesped(dni, nombre, apellido, correo, domicilio, telefono, estado) "
                + "+ VALUES (?, ?, ?, ? ,?, ?, ?)";
                
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, huesped.getDni());
            ps.setString(2, huesped.getNombre());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getCorreo());
            ps.setString(5, huesped.getDomicilio());
            ps.setString(6, huesped.getTelefono());
            ps.setBoolean(7, huesped.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                huesped.setIdHuesped(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Huesped añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");

        }
    }
    
    
    
}
