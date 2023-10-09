/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s.accesoADatos;

import granhotel80s.entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author herna
 */
public class TipoHabitacionData {
        private Connection con = null;
        
    public TipoHabitacionData() {
         con = Conexion.getConnection();
}
    
    public void guardarTipoHabitacion(TipoHabitacion tHabitacion){
        String sql = "INSERT INTO tipohabitacion(idHabitacion, codigo, cantMaxPersonas, CantCamas, TipoDeCamas, Precio, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tHabitacion.getIdHabitacion());
            ps.setString(2, tHabitacion.getCodigo());
            ps.setInt(3, tHabitacion.getCantMaxPersonas());
            ps.setInt(4, tHabitacion.getCantCamas());
            ps.setString(5, tHabitacion.getTipoDeCamas());
            ps.setDouble(6, tHabitacion.getPrecio());
            ps.setBoolean(7, tHabitacion.isEstado()); 
            
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                tHabitacion.setIdTipoHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Tipo de habitacion añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
        }
    
        

    
    
    
    
    }  
}
