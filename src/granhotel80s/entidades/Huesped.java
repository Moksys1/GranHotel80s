package granhotel80s.entidades;

public class Huesped {

    private int idHuesped;
    private int dni;
    private String nombre;
    private String apellido;
    private String correo;
    private String domicilio;
    private String telefono;
    private boolean estado;

    public Huesped() {
    }

    public Huesped(int idHuesped, int dni, String nombre, String apellido, String correo, String domicilio, String telefono, boolean estado) {
        this.idHuesped = idHuesped;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Huesped(int dni, String nombre, String apellido, String correo, String domicilio, String telefono, boolean estado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estado = estado;
    }

    public int getIdHuesped() {
        return idHuesped;
    }

    public void setIdHuesped(int idHuesped) {
        this.idHuesped = idHuesped;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Huesped{" + "idHuesped=" + idHuesped + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + '}';
    }
}
