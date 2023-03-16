public class Datos_usuarios {

    private String nombre;
    private String apellido;
    private String alias;
    private String correo;
    private String dpi;
    private String telefono;
    private String pass;
    private String rol;
    private String fechanacimiento;
    private String nacionalidad;
    private String genero;

    public Datos_usuarios(String nombre, String apellido, String alias, String correo, String dpi, String telefono, String pass, String rol, String fechanacimiento, String nacionalidad, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.alias = alias;
        this.correo = correo;
        this.dpi = dpi;
        this.telefono = telefono;
        this.pass = pass;
        this.rol = rol;
        this.fechanacimiento = fechanacimiento;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "," + apellido + "- Correo: " + correo;
    }
}
