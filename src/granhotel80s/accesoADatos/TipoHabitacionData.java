/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s.accesoADatos;

import com.sun.org.apache.xerces.internal.util.FeatureState;
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

    public void guardarTipoHabitacion(TipoHabitacion tHabitacion) {
        String sql = "INSERT INTO tipohabitacion(codigo, cantMaxPersonas, CantCamas, TipoDeCamas, Precio, estado)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, tHabitacion.getCodigo());
            ps.setInt(2, tHabitacion.getCantMaxPersonas());
            ps.setInt(3, tHabitacion.getCantCamas());
            ps.setString(4, tHabitacion.getTipoDeCamas());
            ps.setDouble(5, tHabitacion.getPrecio());
            ps.setBoolean(6, tHabitacion.isEstado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                tHabitacion.setIdTipoHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Tipo de habitacion añadida con exito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
        }
    }

    public void modificarTipoHabitacion(TipoHabitacion tHabitacion) {
        String sql = "UPDATE tipohabitacion SET codigo = ? ,cantMaxPersonas = ?, CantCamas = ?, "
                + "TipoDeCamas = ?, Precio = ? ,estado = ? WHERE idTipoHabitacion = ? ";
        
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            
            
            ps.setString(1, tHabitacion.getCodigo());
            ps.setInt(2, tHabitacion.getCantMaxPersonas());
            ps.setInt(3, tHabitacion.getCantCamas());
            ps.setString(4, tHabitacion.getTipoDeCamas());
            ps.setDouble(5, tHabitacion.getPrecio());
            ps.setBoolean(6, tHabitacion.isEstado());
            ps.setInt(7, tHabitacion.getIdTipoHabitacion());

            int exito = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (exito > 0) {
                tHabitacion.setIdTipoHabitacion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Tipo de habitacion modificada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "El tipo de habitacion buscada no existe");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la blablablabla Tabla TipoHabitacion");
        }

    }
}
