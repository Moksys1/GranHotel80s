/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s;

import granhotel80s.accesoADatos.Conexion;
import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.entidades.Habitacion;
import granhotel80s.entidades.Huesped;
import java.sql.Connection;

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
        
//----------------------------------------------------------------------------------------           
        //Huesped persona = new Huesped(2, 42862742, "Or", "Fornas", "orlandofornas@gmail.com", "Reconquista", "2615970271", true);
        
        //agregar Huesped
        //hd.guardarHuesped(persona);

//-----------------------------------------------------------------------------------------          
         //Eliminar Huesped 
        // hd.eliminarHuesped(2);
        
//----------------------------------------------------------------------------------------
        
        // buscar huesped
        //hd.BuscarHuesped(2);
        
//----------------------------------------------------------------------------------------        

          //Modificar Datos del huesped
          //hd.modificarHuesped(persona);
    
//----------------------------------------------------------------------------------------    

     
        //agregar habitacion
        Habitacion cuarto = new Habitacion("Doble", 1, 1, true);
        //habiData.guardarHabitacion(cuarto);
        
//----------------------------------------------------------------------------------------        

        //eliminar habitacion
        //habiData.eliminarHabitacion(1);
        
//----------------------------------------------------------------------------------------  

       //modificar habitacion
       //habiData.modificarHabitacion(cuarto);

//---------------------------------------------------------------------------------------- 
        
        //obtener habitaciones
     /*  for (Habitacion habit : habiData.obtenerHabitaciones()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */

//----------------------------------------------------------------------------------------      
        //obtener habitaciones desocupadas
    /*   for (Habitacion habit : habiData.obtenerHabitacionesDesopupadas()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */

//----------------------------------------------------------------------------------------         
       
        //obtener habitaciones ocupadas
    /*   for (Habitacion habit : habiData.obtenerHabitacionesOcupadas()) {
            
           System.out.println("id: "+ habit.getIdHabitacion());
           System.out.println("Categoria: "+ habit.getCategoria());
           System.out.println("Piso: "+ habit.getPiso());
           System.out.println("Numero de habitacion: "+ habit.getNroHabitacion());
           System.out.println("Estado: "+ habit.isEstado());
            System.out.println("------------");
        }  */
    
       
    }
}
