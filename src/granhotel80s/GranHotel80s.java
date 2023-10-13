/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s;

import granhotel80s.accesoADatos.Conexion;
import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.accesoADatos.ReservaData;
import granhotel80s.accesoADatos.TipoHabitacionData;
import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.Huesped;
import granhotel80s.entidades.Reserva;
import granhotel80s.entidades.TipoHabitacion;
import java.sql.Connection;
import java.time.LocalDate;

/**
 *
 * @author Moksys
 */
public class GranHotel80s {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Connection con = Conexion.getConnection();
        HuespedData hd = new HuespedData();
        HabitacionData habiData = new HabitacionData();
        TipoHabitacionData tHabData1 = new TipoHabitacionData();
        ReservaData reserData = new ReservaData();

        TipoHabitacion tHab1 = new TipoHabitacion(213, "SuQSi", 3, 2, "QSi", 22500, true);
//        TipoHabitacion tHab213 = new TipoHabitacion(1, 213, "ET3S", 3, 2, "3S", 7250, true);

//----------------------------------------------------------------------------------------
        // Test de tipo de habitacion
        //tHabData1.modificarTipoHabitacion(tHab213);
        //tHabData1.guardarTipoHabitacion(tHab1);
        
//----------------------------------------------------------------------------------------         

        //--------------agregar Huesped--------------
        //Huesped persona = new Huesped(2, 42862742, "Or", "Fornas", "orlandofornas@gmail.com", "Reconquista", "2615970271", true);
        //hd.guardarHuesped(persona);
        
        //--------------Eliminar Huesped --------------
        // hd.eliminarHuesped(2);
        
        //-------------- buscar huesped--------------
        //hd.BuscarHuesped(2);
        
        //--------------Modificar Datos del huesped--------------
        //hd.modificarHuesped(persona);
        
        //--------------Listar Huespedes--------------
      /*  for (Huesped hues : hd.listarHuesped()) {

            System.out.println("id: " + hues.getIdHuesped());
            System.out.println("Dni: " + hues.getDni());
            System.out.println("Nombre: " + hues.getNombre());
            System.out.println("Apellido: " + hues.getApellido());
            System.out.println("Correo: " + hues.getCorreo());
            System.out.println("Domicilio: " + hues.getDomicilio());
            System.out.println("Telefono: " + hues.getTelefono());
            System.out.println("Estado: " + hues.isEstado());
            System.out.println("------------");
        } */
        
//-----------------------------------------------------------------------------------------  

        //--------------agregar habitacion--------------
        //Habitacion cuarto = new Habitacion(3, "Queen", 1, 3, true);
        //habiData.guardarHabitacion(cuarto); 
        
        //--------------eliminar habitacion--------------
        //habiData.eliminarHabitacion(4);
        
        //--------------modificar habitacion--------------
        //habiData.modificarHabitacion(cuarto);
        
        //--------------obtener habitaciones--------------
        /*for (Habitacion habit : habiData.obtenerHabitaciones()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("idTipoHabitacion: "+ habit.getIdTipoHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */
        //--------------obtener habitaciones desocupadas--------------
        /* for (Habitacion habit : habiData.obtenerHabitacionesDesopupadas()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("idTipoHabitacion: "+ habit.getIdTipoHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */
        //--------------obtener habitaciones ocupadas-----------------
        /*  for (Habitacion habit : habiData.obtenerHabitacionesOcupadas()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("idTipoHabitacion: "+ habit.getIdTipoHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */
//----------------------------------------------------------------------------------------  
        //Crear reserva
        //Reserva solicitud = new Reserva(1, 1, 4, 4, LocalDate.of(2023, 10, 01), LocalDate.of(2023, 10, 15), true);
        //reserData.crearReserva(solicitud);

        //------Eliminar Reserva------
        //reserData.eliminarReserva(1);
        
        //---------Buscar Reserva---------
        //reserData.BuscarReserva(1);
        
        //---------Modificar Reserva----------
        //reserData.modificarReserva(solicitud);
        
        //---------Cambiar estado de reserva---------
        //reserData.cambiarEstadoReserva(1);
        
        //----------Listar reservas----------
        
       /* for (Reserva reser : reserData.listarReservas()) {

            System.out.println("id: " + reser.getIdReserva());
            System.out.println("id huesped: " + reser.getIdHuesped());
            System.out.println("id habitacion: " + reser.getIdHabitacion());
            System.out.println("Cantidad de personas: " + reser.getCantPersonas());
            System.out.println("Fecha de entrada: " + reser.getFechaEntrada());
            System.out.println("Fecha de salida: " + reser.getFechaSalida());
            System.out.println("------------");
        } */

    }

}
