package granhotel80s;

import granhotel80s.accesoADatos.Conexion;
import granhotel80s.accesoADatos.HabitacionData;
import granhotel80s.accesoADatos.HuespedData;
import granhotel80s.accesoADatos.TipoHabitacionData;
import java.sql.Connection;

public class GranHotel80s {

    public static void main(String[] args) {
        
        Connection con = Conexion.getConnection();
        HuespedData hd = new HuespedData();
        HabitacionData habiData = new HabitacionData();
        //TipoHabitacion tHab1 = new TipoHabitacion(213, "SuQSi", 3, 2, "QSi", 22500, true);
        
        //TipoHabitacion tHab213 = new TipoHabitacion(1, 213, "ET3S", 3, 3, "3S", 8550, true);
//        TipoHabitacion tHab11 = new TipoHabitacion(1, 11, "ET3S", 2, 3, "3S", 7050, true);
        
//        TipoHabitacionData tHabData1 = new TipoHabitacionData();
//----------------------------------------------------------------------------------------
        // Test de tipo de habitacion
        //tHabData1.modificarTipoHabitacion(tHab213);
//        tHabData1.guardarTipoHabitacion(tHab11);
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
        //Habitacion cuarto = new Habitacion("Doble", 1, 1, true);
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
