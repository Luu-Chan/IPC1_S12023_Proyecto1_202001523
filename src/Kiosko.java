public class Kiosko extends Ubicacion{

    private Municipio municipio;


    public Kiosko(String codigo, String nombre, Municipio municipio) {
        super(codigo, nombre);
        this.municipio = municipio;
    }


    public Municipio getMunicipio() {return municipio;}

    public void setMunicipio(Municipio municipio) {this.municipio = municipio;}


}
