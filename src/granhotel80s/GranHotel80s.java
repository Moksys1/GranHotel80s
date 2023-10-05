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
        
        //agregar Huesped
        
        //Huesped persona = new Huesped(2, 42862742, "Or", "Fornas", "orlandofornas@gmail.com", "Reconquista", "2615970271", true);
        //hd.guardarHuesped(persona);
        
//----------------------------------------------------------------------------------------------------      

        //Eliminar Huesped 
        //hd.eliminarHuesped(2);
        
//----------------------------------------------------------------------------------------------------
        
        //buscar huesped
        //hd.BuscarHuesped(2);

//----------------------------------------------------------------------------------------------------

          //Modificar Datos del huesped
          //hd.modificarHuesped(persona);
    
//----------------------------------------------------------------------------------------------------

        //Agragar habitacion
        Habitacion habi = new Habitacion(1, "Simple", 2, 1, true);
        //habiData.guardarHabitacion(habi);
          
//----------------------------------------------------------------------------------------------------

        //Modificar habitacion
        habiData.modificarHabitacion(habi);
        
    }

    
}
