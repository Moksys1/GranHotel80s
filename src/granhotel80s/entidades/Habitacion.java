package granhotel80s.entidades;

public class Habitacion {

    private int idHabitacion;
    private int idTipoHabitacion;
    private String categoria;
    private int Piso;
    private int nroHabitacion;
    private boolean estado;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int idTipoHabitacion, String categoria, int Piso, int nroHabitacion, boolean estado) {
        this.idHabitacion = idHabitacion;
        this.idTipoHabitacion = idTipoHabitacion;
        this.categoria = categoria;
        this.Piso = Piso;
        this.nroHabitacion = nroHabitacion;
        this.estado = estado;
    }

    public Habitacion(int idTipoHabitacion, String categoria, int Piso, int nroHabitacion, boolean estado) {
        this.idTipoHabitacion = idTipoHabitacion;
        this.categoria = categoria;
        this.Piso = Piso;
        this.nroHabitacion = nroHabitacion;
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdTipoHabitacion() {
        return idTipoHabitacion;
    }

    public void setIdTipoHabitacion(int idTipoHabitacion) {
        this.idTipoHabitacion = idTipoHabitacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPiso() {
        return Piso;
    }

    public void setPiso(int Piso) {
        this.Piso = Piso;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  categoria ;
    }

}
