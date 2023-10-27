package granhotel80s.accesoADatos;

import granhotel80s.entidades.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HuespedData {
    
    private Connection con = null;
    
    public HuespedData() {
         con = Conexion.getConnection();
}
   
    public void guardarHuesped(Huesped huesped) {
        String sql = "INSERT INTO huesped(dni, nombre, apellido, correo, domicilio, telefono, estado) "
                + " VALUES (?, ?, ?, ? ,?, ?, ?)";
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
     public void eliminarHuesped(int id) {
        String sql = "UPDATE huesped SET estado = 0 WHERE idHuesped = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Huesped eliminado correctamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Huesped.");
        }
    }
     
    public Huesped BuscarHuesped(int id) {
        Huesped huesped = null;
        String sql = "SELECT idHuesped, dni, nombre, apellido, correo, domicilio, telefono FROM huesped WHERE idHuesped = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getInt("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEstado(true);

                System.out.println(huesped);
            } else {
                JOptionPane.showMessageDialog(null, "No existe este Huesped.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped.");
        }
        return huesped;
    }
    
    public Huesped BuscarHuespedPorDni(int dni) {
        Huesped huesped = null;
        String sql = "SELECT idHuesped, dni, nombre, apellido, correo, domicilio, telefono FROM huesped WHERE dni=? AND estado =1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                huesped = new Huesped();
                huesped.setIdHuesped(rs.getInt("idHuesped"));
                huesped.setDni(rs.getInt("dni"));
                huesped.setNombre(rs.getString("nombre"));
                huesped.setApellido(rs.getString("apellido"));
                huesped.setCorreo(rs.getString("correo"));
                huesped.setDomicilio(rs.getString("domicilio"));
                huesped.setTelefono(rs.getString("telefono"));
                huesped.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe un huesped con el DNI ingresado.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped.");
        }
        return huesped;
    }
    
    public void modificarHuesped (Huesped huesped) {
        String sql ="UPDATE huesped SET dni = ? , nombre = ? , apellido = ? , correo = ? , domicilio = ? , telefono = ? WHERE idHuesped = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, huesped.getDni());
            ps.setString(2, huesped.getNombre());
            ps.setString(3, huesped.getApellido());
            ps.setString(4, huesped.getCorreo());
            ps.setString(5,huesped.getDomicilio() );
            ps.setString(6, huesped.getTelefono());
            ps.setInt(7, huesped.getIdHuesped());
            
            
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El huesped buscado no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla huesped");
        }
    }
    
    public List<Huesped> listarHuesped() {
        ArrayList<Huesped> huesped = new ArrayList<>();
        String sql = "SELECT * FROM huesped";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Huesped hues = new Huesped();
                hues.setIdHuesped(rs.getInt("idHuesped"));
                hues.setDni(rs.getInt("dni"));
                hues.setNombre(rs.getString("nombre"));
                hues.setApellido(rs.getString("apellido"));
                hues.setCorreo(rs.getString("correo"));
                hues.setDomicilio(rs.getString("domicilio"));
                hues.setTelefono(rs.getString("telefono"));
                hues.setEstado(rs.getBoolean("estado"));
                huesped.add(hues);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion.");
        }
        return huesped;
    }
}
