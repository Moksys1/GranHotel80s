/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s;

import granhotel80s.accesoADatos.Conexion;
import granhotel80s.accesoADatos.HuespedData;
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
        //agregar Huesped
//        Huesped persona = new Huesped(42862742, "or", "Fornas", "orlandofornas@gmail.com", "Reconquista", "2615970271", true);
        //hd.guardarHuesped(persona);
        //Eliminar Huesped 
         
        //hd.eliminarHuesped(2);
        // buscar huesped
        hd.BuscarHuesped(2);
          // Modificar Datos del huesped
//          Huesped persona = new Huesped();
//          persona.setIdHuesped(2);
//          persona.setNombre("kevin");
//       hd.modificarHuesped(persona);
    
    

          
       
    }

    
}
