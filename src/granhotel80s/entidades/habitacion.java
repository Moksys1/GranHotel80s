
package granhotel80s.entidades;

public class habitacion {
    
    private int idHabitacion;
    private String categoria;
    private int Piso;
    private int nroHabitacion;
    private boolean estado;

    public habitacion() {
    }

    public habitacion(int idHabitacion, String categoria, int Piso, int nroHabitacion, boolean estado) {
        this.idHabitacion = idHabitacion;
        this.categoria = categoria;
        this.Piso = Piso;
        this.nroHabitacion = nroHabitacion;
        this.estado = estado;
    }

    public habitacion(String categoria, int Piso, int nroHabitacion, boolean estado) {
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
        return "habitacion{" + "idHabitacion=" + idHabitacion + ", categoria=" + categoria + ", Piso=" + Piso + ", nroHabitacion=" + nroHabitacion + ", estado=" + estado + '}';
    }
    
}
