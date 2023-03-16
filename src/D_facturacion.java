public class D_facturacion {

    private String nombre;
    private String direccion;
    private String nit;
    private String id_registro;

    public D_facturacion(String nombre, String direccion, String nit, String id_registro) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.id_registro = id_registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getId_registro() {
        return id_registro;
    }

    public void setId_registro(String id_registro) {
        this.id_registro = id_registro;
    }


    @Override
    public String toString() {
        return "-Nombre: " + nombre + " - Direccion: " + direccion + " - Nit " + nit;
    }
}
