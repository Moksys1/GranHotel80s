package granhotel80s.entidades;

import java.time.LocalDate;

public class Reserva {

    private int idReserva;
    private int idHuesped;
    private int idHabitacion;
    private int cantPersonas;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private boolean estado;

    public Reserva() {
    }

    public Reserva(int idReserva, int idHuesped, int idHabitacion, int cantPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, boolean estado) {
        this.idReserva = idReserva;
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
    }

    public Reserva(int idHuesped, int idHabitacion, int cantPersonas, LocalDate fechaEntrada, LocalDate fechaSalida, boolean estado) {
        this.idHuesped = idHuesped;
        this.idHabitacion = idHabitacion;
        this.cantPersonas = cantPersonas;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "" + "" + idReserva + "," + idHuesped + "," + idHabitacion + "," + cantPersonas + "," + fechaEntrada + "," + fechaSalida + "," + estado + '}';
    }
}
