public class Departamento extends Ubicacion {

    private Regiones region;



    public Departamento(String codigo, String nombre, Regiones region) {
        super(codigo, nombre);
        this.region = region;
    }

    public Regiones getRegion() {
        return region;
    }

    public void setRegion(Regiones region) {
        this.region = region;
    }
}
