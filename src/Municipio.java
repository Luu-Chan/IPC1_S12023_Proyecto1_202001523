public class Municipio extends Ubicacion{

    private Departamento departamento;


    public Municipio(String codigo, String nombre, Departamento departamento) {
        super(codigo, nombre);
        this.departamento = departamento;

    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "-" + departamento + ", " + getNombre() ;
    }
}
