/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granhotel80s.entidades;

import java.time.LocalDate;

/**
 *
 * @author Usuario
 */
public class Reserva {
    private int idReserva ;
    private int idHuesped;
    private int idHabitacion;
    private int  cantPersonas;
    private  LocalDate fechaEntrada;
    private  LocalDate fechaSalida;
    private double importeTotal; 
    private boolean estado;	

    public Reserva(int idReserva, int idHuesped, int idHabitacion, int cantPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estado) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estado = estado;
    }

    public Reserva(int cantPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, double importeTotal, boolean estado) {
        this.cantPersonas = cantPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.importeTotal = importeTotal;
        this.estado = estado;
    }

  public Reserva (){
  }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idHuesped=" + idHuesped + ", idHabitacion=" + idHabitacion + ", cantPersonas=" + cantPersonas + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", importeTotal=" + importeTotal + ", estado=" + estado + '}';
    }

}
