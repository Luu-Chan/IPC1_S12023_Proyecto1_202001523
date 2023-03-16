public class Ventas {

    private String id_compra;
    private String destino;
    private String origen;
    private String direccion;
    private String metodo_pago;
    private Double cantidad;
    private String tamanio;
    private double totalpago;
    private String id_paquete;

    public Ventas(String id_compra, String destino, String origen, String direccion, String metodo_pago, Double cantidad, String tamanio, double totalpago, String id_paquete) {
        this.id_compra = id_compra;
        this.destino = destino;
        this.origen = origen;
        this.direccion = direccion;
        this.metodo_pago = metodo_pago;
        this.cantidad = cantidad;
        this.tamanio = tamanio;
        this.totalpago = totalpago;
        this.id_paquete = id_paquete;
    }

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public double getTotalpago() {
        return totalpago;
    }

    public void setTotalpago(double totalpago) {
        this.totalpago = totalpago;
    }

    public String getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(String id_paquete) {
        this.id_paquete = id_paquete;
    }

    @Override
    public String toString() {
        return "ID paquete:" + id_paquete + "- Destino " + destino + "- Total: " + totalpago ;
    }
}
