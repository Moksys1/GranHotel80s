//⮚	El proceso de hacer una Reserva se organizará. El método Crear Reserva:
//1.	Se introduce por teclado fechaEntrada y fechaSalida y cantidad de personas.
//2.	Se busca un “tipo de habitación” para esa cantidad de personas y el precio. 
//3.	Se devuelve una lista de las habitaciones que estén Libres, de ese “Tipo Habitación”.
//Calcular monto estadía:  en la reserva, se calcula como precio por noche (de Tipo Habitación) por cantidad de días de estadía ingresado. Devuelve el monto*.
//4.	Se construye la reserva con fechaCheckin, fechaCheckout, Huésped, Habitación, monto*, estado=1.
//5.	La Habitación se marca Ocupada(1), en la fecha de salida vuelve a su estado Libre.
//
//⮚	Método “finReserva” recibe un Huésped, permite buscar una reserva se marca, de Activa(1) a Inactiva(0). Se busca la habitación y se marca Libre(0). 
//⮚	Búsqueda de Reservas por huésped o fechas: devuelve una Reserva.

package granhotel80s.accesoADatos;

import granhotel80s.entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ReservaData {
    
    
    private Connection con = null;

    {

        con = Conexion.getConnection();

    }
     public void crearReserva(Reserva reser) {

        String sql = "reserva(idHuesped, idHabitacion, cantPersonas, fechaEntrada, fechaSalida, importeTotal, estado)"
                + "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, reser.getIdHuesped());
            ps.setInt(2, reser.getIdHabitacion());
            ps.setInt(3, reser.getCantPersonas());
            ps.setDate(4,Date.valueOf(reser.getFechaEntrada()));
            ps.setDate(5,Date.valueOf(reser.getFechaSalida()));
            ps.setDouble(6, reser.getImporteTotal());
            ps.setBoolean(7, reser.isEstado());
            ps.executeQuery();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                reser.setIdReserva(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "reserva con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva");

       }
     }
         public void eliminarReserva(int id) {
        String sql = "UPDATE reserva SET estado = 0 WHERE idReserva = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "reserva eliminada correctamente.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva.");
        }
        
    }
      
        public Reserva BuscarReserva(int id) {
        Reserva reserva = null;
        String sql = "UPDATE reserva SET idReserva, idHuesped,idHabitacion,cantPersonas,fechaEntrada,fechaSalida,importeTotal,estado WHERE 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reserva= new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdHuesped(rs.getInt("idHuesped"));
                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
                reserva.setCantPersonas(rs.getInt("cantPersonas"));
//                reserva.setNombre(rs.getString("nombre"));
//                reserva.setApellido(rs.getString("apellido"));
//                reserva.setCorreo(rs.getString("correo"));
//                reserva.setDomicilio(rs.getString("domicilio"));
//                reserva.setTelefono(rs.getString("telefono"));
                reserva.setEstado(true);

                System.out.println(reserva);
            } else {
                JOptionPane.showMessageDialog(null, "No existe esta reserva.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva.");
        }
        return reserva;
    }
 }

