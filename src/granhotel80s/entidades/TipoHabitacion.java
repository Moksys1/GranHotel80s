/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s.entidades;

/**
 *
 * @author herna
 */
public class TipoHabitacion {
    private int idTipoHabitacion;
    private int idHabitacion;
    private String codigo;
    private int cantMaxPersonas;
    private int CantCamas;
    private String TipoDeCamas;
    private double Precio;
    private boolean estado;

    public TipoHabitacion() {
    }

    public TipoHabitacion(int idTipoHabitacion, int idHabitacion, String codigo, int cantMaxPersonas, int CantCamas, String TipoDeCamas, double Precio, boolean estado) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.idHabitacion = idHabitacion;
        this.codigo = codigo;
        this.cantMaxPersonas = cantMaxPersonas;
        this.CantCamas = CantCamas;
        this.TipoDeCamas = TipoDeCamas;
        this.Precio = Precio;
        this.estado = estado;
    }

    public TipoHabitacion(int idHabitacion, String codigo, int cantMaxPersonas, int CantCamas, String TipoDeCamas, double Precio, boolean estado) {
        this.idHabitacion = idHabitacion;
        this.codigo = codigo;
        this.cantMaxPersonas = cantMaxPersonas;
        this.CantCamas = CantCamas;
        this.TipoDeCamas = TipoDeCamas;
        this.Precio = Precio;
        this.estado = estado;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantMaxPersonas() {
        return cantMaxPersonas;
    }

    public void setCantMaxPersonas(int cantMaxPersonas) {
        this.cantMaxPersonas = cantMaxPersonas;
    }

    public int getCantCamas() {
        return CantCamas;
    }

    public void setCantCamas(int CantCamas) {
        this.CantCamas = CantCamas;
    }

    public String getTipoDeCamas() {
        return TipoDeCamas;
    }

    public void setTipoDeCamas(String TipoDeCamas) {
        this.TipoDeCamas = TipoDeCamas;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoHabitacion{" + "idHabitacion=" + idHabitacion + ", codigo=" + codigo + ", cantMaxPersonas=" + cantMaxPersonas + ", CantCamas=" + CantCamas + ", TipoDeCamas=" + TipoDeCamas + ", Precio=" + Precio + ", estado=" + estado + '}';
    }
    
    
}
