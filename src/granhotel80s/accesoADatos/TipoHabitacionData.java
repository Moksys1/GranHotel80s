/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s.accesoADatos;

import com.sun.org.apache.xerces.internal.util.FeatureState;
import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.TipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hernan
 */
public class TipoHabitacionData {

    private Connection con = null;

    public TipoHabitacionData() {
        con = Conexion.getConnection();
    }

    public void guardarTipoHabitacion(TipoHabitacion tHabitacion) {
        if (tHabitacion.getIdTipoHabitacion() == 0) {
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
                //======= Modifica el resto de parametros de tipoHabitacion exepto el ID =======.
                if (rs.next()) {
                    tHabitacion.setIdTipoHabitacion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Tipo de habitacion añadida con exito.");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
            }
            //======= Modifica tambien el ID de tipoHabitacion ademas de los otros parametros =======.
        } else {
            String sql = "INSERT INTO tipohabitacion(idTipoHabitacion, codigo, cantMaxPersonas, CantCamas, TipoDeCamas, Precio, estado)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, tHabitacion.getIdTipoHabitacion());
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
                    JOptionPane.showMessageDialog(null, "Tipo de habitacion añadida con exito.");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
            }
        }
    }

    public TipoHabitacion buscarTipoHabitacion(String codigo) {
        TipoHabitacion tHab = new TipoHabitacion();
        String sql = "SELECT idTipoHabitacion, codigo, cantMaxPersonas, CantCamas, TipoDeCamas, Precio FROM tipohabitacion WHERE codigo = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tHab.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tHab.setCodigo(rs.getString("codigo"));
                tHab.setCantMaxPersonas(rs.getInt("cantMaxPersonas"));
                tHab.setCantCamas(rs.getInt("CantCamas"));
                tHab.setTipoDeCamas(rs.getString("TipoDeCamas"));
                tHab.setPrecio(rs.getDouble("Precio"));
                tHab.setEstado(true);
                System.out.println(tHab.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Tipo de Habitacion.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion.");
        }
        return tHab;
    }

    public Double buscarPrecioTHab(int idTipoHAbitacion) {
        TipoHabitacion tHabPrecio = new TipoHabitacion();
        String sql = "SELECT Precio FROM tipohabitacion WHERE idTipoHabitacion = ? AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTipoHAbitacion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tHabPrecio.setPrecio(rs.getDouble("Precio"));
                System.out.println(tHabPrecio.getPrecio());
            }else {
                JOptionPane.showMessageDialog(null, "No existe ese Tipo de Habitacion.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla TipoHabitacion.");
        }
        return tHabPrecio.getPrecio();
    }

    public void modificarTipoHabitacion(TipoHabitacion mTHabitacion) {
        String sql = "UPDATE tipohabitacion SET codigo = ?, cantMaxPersonas = ?, CantCamas = ?, TipoDeCamas = ?, Precio = ?, estado = ? WHERE idTipoHabitacion = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, mTHabitacion.getCodigo());
            ps.setInt(2, mTHabitacion.getCantMaxPersonas());
            ps.setInt(3, mTHabitacion.getCantCamas());
            ps.setString(4, mTHabitacion.getTipoDeCamas());
            ps.setDouble(5, mTHabitacion.getPrecio());
            ps.setBoolean(6, mTHabitacion.isEstado());
            ps.setInt(7, mTHabitacion.getIdTipoHabitacion());
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, " Tipo de habitacion modificada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "El tipo de habitacion buscada no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
        }
    }

    public void eliminarTipoHabitacion(int IdTHab) {
        String sql = "UPDATE tipohabitacion SET estado = 0 WHERE idTipoHabitacion = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, IdTHab);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Tipo de Habitacion eliminada correctamente.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
        }
    }

    public void cambiarPrecio(double prec, String cod) {
        String sql = "UPDATE tipohabitacion SET Precio = ? WHERE codigo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, prec);
            ps.setString(2, cod);
            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, " Precio de habitacion modificado con exito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla TipoHabitacion");
        }
    }
     public List<TipoHabitacion> listarTipoHabitacion() {

        ArrayList<TipoHabitacion> listarTipoH = new ArrayList<>();

        String sql = "SELECT * FROM tipohabitacion";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                TipoHabitacion tipohab = new TipoHabitacion();
                tipohab.setIdTipoHabitacion(rs.getInt("idTipoHabitacion"));
                tipohab.setCodigo(rs.getString("codigo"));
                tipohab.setCantMaxPersonas(rs.getInt("cantMaxPersonas"));
                tipohab.setCantCamas(rs.getInt("CantCamas"));
                tipohab.setTipoDeCamas(rs.getString("TipoDeCamas"));
                tipohab.setPrecio(rs.getDouble("Precio"));
                tipohab.setEstado(rs.getBoolean("estado"));
                listarTipoH.add(tipohab);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla tipo habitacion.");
        }

        return listarTipoH;

    }
}
