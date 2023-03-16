import java.util.ArrayList;

public class Main {


    public static ArrayList<Datos_usuarios> usuariosreg = new ArrayList<>();

    public static ArrayList<Regiones> regiones = new ArrayList<>();
    public static ArrayList<Departamento> departamentos = new ArrayList<>();

    public static ArrayList<Municipio> municipios = new ArrayList<>();
    public static ArrayList<Kiosko> kioskos = new ArrayList<>();
    public static ArrayList<Credic_Cards> tarjetas = new ArrayList<>();
    public static ArrayList<D_facturacion> datosfac = new ArrayList<>();
    public static ArrayList<Ventas> venta = new ArrayList<>();



    public static boolean validarpass(String pass) {

        boolean validacion= false;

        if (pass.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[^A-Za-z0-9]).{8,}")) {
            validacion=true;

        } else {
            validacion = false;
        }
        return validacion;
    }
}






