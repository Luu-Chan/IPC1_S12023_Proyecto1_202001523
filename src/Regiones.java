import java.util.ArrayList;

public class Regiones extends Ubicacion {



    private Double precio_standar;

    private Double precio_especial;


    public Regiones(String codigo, String nombre, Double precio_standar, Double precio_especial) {
        super(codigo, nombre);
        this.precio_standar = precio_standar;
        this.precio_especial = precio_especial;
    }

    public Double getPrecio_standar() {
        return precio_standar;
    }

    public void setPrecio_standar(Double precio_standar) {
        this.precio_standar = precio_standar;
    }

    public Double getPrecio_especial() {
        return precio_especial;
    }

    public void setPrecio_especial(Double precio_especial) {
        this.precio_especial = precio_especial;
    }


}
