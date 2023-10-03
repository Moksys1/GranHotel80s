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
        
        Huesped persona = new Huesped(42862742, "Orlando", "Fornas", "orlandofornas@gmail.com", "Reconquista", "2615970271", true);
        hd.guardarHuesped(persona);
        
        
    }
    
}
