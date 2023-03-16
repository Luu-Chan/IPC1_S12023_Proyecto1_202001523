public class Credic_Cards {

    private String tarjeta;
    private String fecha_vencimiento;
    private String id_registro ;

    private String numero_tarjeta;

    public Credic_Cards( String tarjeta, String fecha_vencimiento, String numero_tarjeta, String id_registro) {

        this.tarjeta = tarjeta;
        this.fecha_vencimiento = fecha_vencimiento;
        this.id_registro = id_registro;
        this.numero_tarjeta = numero_tarjeta;
    }


    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getId_registro() {
        return id_registro;
    }

    public void setId_registro(String id_registro) {
        this.id_registro = id_registro;
    }
    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    @Override
    public String toString() {
        return "-Nombre tarjeta: " + tarjeta + " - Numero tarjeta: " + numero_tarjeta + " - Caducidad " + fecha_vencimiento;
    }
}
