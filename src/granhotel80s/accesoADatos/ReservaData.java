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

import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.Huesped;
import granhotel80s.entidades.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

        String sql = "INSERT INTO reserva(idHuesped, idHabitacion, cantPersonas, fechaEntrada, fechaSalida, estado)"
                + "VALUES ( ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, reser.getIdHuesped());
            ps.setInt(2, reser.getIdHabitacion());
            ps.setInt(3, reser.getCantPersonas());
            ps.setDate(4, Date.valueOf(reser.getFechaEntrada()));
            ps.setDate(5, Date.valueOf(reser.getFechaSalida()));
            ps.setBoolean(6, reser.isEstado());
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
        String sql = "SELECT idReserva, idHuesped, idHabitacion, cantPersonas, fechaEntrada, fechaSalida FROM reserva WHERE idReserva = ? AND estado = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reserva = new Reserva();
                reserva.setIdReserva(rs.getInt("idReserva"));
                reserva.setIdHuesped(rs.getInt("idHuesped"));
                reserva.setIdHabitacion(rs.getInt("idHabitacion"));
                reserva.setCantPersonas(rs.getInt("cantPersonas"));
                reserva.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                reserva.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
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

    public void modificarReserva(Reserva reser) {
        String sql = "UPDATE reserva SET idHuesped = ?, idHabitacion = ?, cantPersonas = ?, fechaEntrada = ?, fechaSalida = ? WHERE idReserva = ? ";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, reser.getIdHuesped());
            ps.setInt(2, reser.getIdHabitacion());
            ps.setInt(3, reser.getCantPersonas());
            ps.setDate(4, Date.valueOf(reser.getFechaEntrada()));
            ps.setDate(5, Date.valueOf(reser.getFechaSalida()));
            ps.setBoolean(6, reser.isEstado());

            int exito = ps.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "Modificado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "la reserva buscada no existe");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva");
        }

    }

    public void cambiarEstadoReserva(int idReserva) {
        String sql = "UPDATE reserva SET estado = NOT estado WHERE idReserva = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idReserva);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("El estado de la reserva ha sido cambiado con éxito.");
            } else {
                System.out.println("No se pudo cambiar el estado de la reserva.");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Reserva> listarReservas() {

        ArrayList<Reserva> reserva = new ArrayList<>();

        String sql = "SELECT * FROM reserva";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Reserva rese = new Reserva();
                rese.setIdReserva(rs.getInt("idReserva"));
                rese.setIdHuesped(rs.getInt("idHuesped"));
                rese.setIdHabitacion(rs.getInt("idHabitacion"));
                rese.setCantPersonas(rs.getInt("cantPersonas"));
                rese.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                rese.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                rese.setEstado(rs.getBoolean("estado"));
                reserva.add(rese);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla habitacion.");
        }

        return reserva;

    }
    
    public ArrayList<Object[]> filtrarHuespedPorDni(String dni) {
        ArrayList<Object[]> listaDeReservasDeHuesped = new ArrayList<>();

        try {
            String sql = "SELECT reserva.idReserva, huesped.dni, reserva.fechaEntrada, reserva.fechaSalida, habitacion.nroHabitacion, reserva.estado "
                    + "FROM reserva "
                    + "JOIN huesped ON reserva.idHuesped = huesped.idHuesped "
                    + "JOIN habitacion ON reserva.idHabitacion = habitacion.idHabitacion "
                    + "WHERE huesped.dni LIKE ?";
            
            //LIKEse utiliza para buscar un patrón específico dentro de una columna

            PreparedStatement ps = con.prepareStatement(sql);
            // Agregue el símbolo % para buscar cualquier numero en cualquier posición del dni proporcionado
            ps.setString(1, "%" + dni + "%"); 

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva res = new Reserva();
                Huesped hue = new Huesped();
                Habitacion habi = new Habitacion();

                res.setIdReserva(rs.getInt("idReserva"));
                hue.setDni(rs.getInt("dni"));
                res.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                res.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                habi.setNroHabitacion(rs.getInt("nroHabitacion"));
                res.setEstado(rs.getBoolean("estado"));

                Object[] fila = {res.getIdReserva(), hue.getDni(), res.getFechaEntrada(), res.getFechaSalida(), habi.getNroHabitacion(), res.isEstado()};
                listaDeReservasDeHuesped.add(fila);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva. ");
        }

        return listaDeReservasDeHuesped;
    }

    public ArrayList<Object[]> obtenerReservasDelHuesped() {
        ArrayList<Object[]> listaDeReservasDeHuesped = new ArrayList<>();

        try {
            String sql = "SELECT reserva.idReserva, huesped.dni, reserva.fechaEntrada, reserva.fechaSalida, habitacion.nroHabitacion, reserva.estado "
                    + "FROM reserva "
                    + "JOIN huesped ON reserva.idHuesped = huesped.idHuesped "
                    + "JOIN habitacion ON reserva.idHabitacion = habitacion.idHabitacion;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva res = new Reserva();
                Huesped hue = new Huesped();
                Habitacion habi = new Habitacion();

                res.setIdReserva(rs.getInt("idReserva"));
                hue.setDni(rs.getInt("dni"));
                res.setFechaEntrada(rs.getDate("fechaEntrada").toLocalDate());
                res.setFechaSalida(rs.getDate("fechaSalida").toLocalDate());
                habi.setNroHabitacion(rs.getInt("nroHabitacion"));
                res.setEstado(rs.getBoolean("estado"));

                Object[] fila = {res.getIdReserva(), hue.getDni(), res.getFechaEntrada(), res.getFechaSalida(), habi.getNroHabitacion(), res.isEstado()};
                listaDeReservasDeHuesped.add(fila);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reservaaaaaaaas. ");
        }

        return listaDeReservasDeHuesped;
    }

    public void modificarFecha(Date fechaSalida, int idReserva) {
        String sql = "UPDATE reserva SET fechaSalida = ? WHERE idReserva = ?;";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);

            ps.setDate(1, fechaSalida);
            ps.setInt(2, idReserva);

            int exito = ps.executeUpdate();

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla reserva");
        }
    }

}
