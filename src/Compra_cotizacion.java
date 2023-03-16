import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

public class Compra_cotizacion {


    public JPanel compras_cotizacion;
    private JComboBox<Municipio> origen;
    private JComboBox<Municipio> destino;
    private JTextField cantidad;
    private JRadioButton pequeñoRadioButton;
    private JRadioButton medianoRadioButton;
    private JRadioButton grandeRadioButton;
    private JComboBox<Double> tipoenvio;
    private JButton actbuttom;
    private JButton cotizarButton;
    private JComboBox<D_facturacion> direccion;
    private JComboBox<Credic_Cards> tarjeta;
    private JButton pagoConTarjetaButton;
    private JButton pagoEnEfectivoButton;
    private JButton regresarButton;
    private JButton estandarButton;
    private JLabel Lb_cotizar;
    private double item;


    public Compra_cotizacion() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Panel_usuario().P_usuario);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
        actbuttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tipoenvio.removeAllItems();

                int seleccion  = destino.getSelectedIndex();

                item = Main.municipios.get(seleccion).getDepartamento().getRegion().getPrecio_especial();

                tipoenvio.addItem(item);

            }
        });
        estandarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tipoenvio.removeAllItems();

                int seleccion  = destino.getSelectedIndex();

                item = Main.municipios.get(seleccion).getDepartamento().getRegion().getPrecio_standar();

                tipoenvio.addItem(item);


            }
        });
        cotizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(cantidad.getText().length() == 0)   {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double total= 0;

                if(pequeñoRadioButton.isSelected()){

                    total += 25.0;
                } else if (medianoRadioButton.isSelected()) {

                    total += 30.0;
                } else if (grandeRadioButton.isSelected()) {

                    total += 50.0;
                }

                total = total * item * Double.parseDouble(cantidad.getText());

                Lb_cotizar.setText("Q" + total);

            }
        });
        pagoConTarjetaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indexdest = destino.getSelectedIndex();
                int indexori = origen.getSelectedIndex();
                int indexdirecc = direccion.getSelectedIndex();
                int indexcard = tarjeta.getSelectedIndex();
                Double cant = Double.parseDouble(cantidad.getText());

                String dest =  Main.municipios.get(indexdest).getDepartamento().getNombre() + ", " + Main.municipios.get(indexdest).getNombre();
                String origin = Main.municipios.get(indexori).getDepartamento().getNombre() + ", " + Main.municipios.get(indexori).getNombre();
                String direcc = "";
                String size = "";

                String card = Main.tarjetas.get(indexcard).getNumero_tarjeta();
                direcc = Main.datosfac.get(indexdirecc).getNombre() + ", Nit: " + Main.datosfac.get(indexdirecc).getNit() + ", Direccion :" + Main.datosfac.get(indexdirecc).getDireccion();


                double total= 0;

                if(pequeñoRadioButton.isSelected()){

                    total += 25.0;
                    size = "Paquete Pequeño";

                } else if (medianoRadioButton.isSelected()) {

                    total += 30.0;
                    size = "Paquete Mediano";

                } else if (grandeRadioButton.isSelected()) {

                    total += 50.0;
                    size = "Paquete Grande";

                }

                total = total * item * Double.parseDouble(cantidad.getText());

                String id_purchase = "IPC1E" + UUID.randomUUID().toString().substring(0,4) + "_";


                Main.venta.add(new Ventas(inicio.id_login,dest, origin, direcc,"Tarjeta credito/debito", cant, size, total, id_purchase ));

                JOptionPane.showInputDialog(inicio.frame, "Ingrese CVC de la tarjeta");

                JOptionPane.showMessageDialog(inicio.frame, "Envio Realizado Exitosamente, Guia: " + id_purchase);


            }
        });
        pagoEnEfectivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int indexdest = destino.getSelectedIndex();
                int indexori = origen.getSelectedIndex();
                int indexdirecc = direccion.getSelectedIndex();
                Double cant = Double.parseDouble(cantidad.getText());

                String dest =  Main.municipios.get(indexdest).getDepartamento().getNombre() + ", " + Main.municipios.get(indexdest).getNombre();
                String origin = Main.municipios.get(indexori).getDepartamento().getNombre() + ", " + Main.municipios.get(indexori).getNombre();
                String direcc = "";
                String size = "";
                direcc = Main.datosfac.get(indexdirecc).getNombre() + ", Nit: " + Main.datosfac.get(indexdirecc).getNit() + ", Direccion :" + Main.datosfac.get(indexdirecc).getDireccion();


                double total= 0;

                if(pequeñoRadioButton.isSelected()){

                    total += 25.0;
                    size = "Paquete Pequeño";

                } else if (medianoRadioButton.isSelected()) {

                    total += 30.0;
                    size = "Paquete Mediano";

                } else if (grandeRadioButton.isSelected()) {

                    total += 50.0;
                    size = "Paquete Grande";

                }

                total = total * item * Double.parseDouble(cantidad.getText()) + 5;

                String id_purchase = "IPC1E" + UUID.randomUUID().toString().substring(0,4) + "_";


                Main.venta.add(new Ventas(inicio.id_login,dest, origin, direcc,"Pago Contra Entrega", cant, size, total, id_purchase ));

                JOptionPane.showMessageDialog(inicio.frame, "Envio Realizado Exitosamente, Guia: " + id_purchase);


            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


        origen = new JComboBox<Municipio>();
        destino = new JComboBox<Municipio>();
        tarjeta = new JComboBox<Credic_Cards>();
        direccion = new JComboBox<D_facturacion>();
        tipoenvio = new JComboBox<Double>();

        pequeñoRadioButton = new JRadioButton( "Pequeño: Q25.00", true);

        for (Municipio mu:
                Main.municipios) {

            origen.addItem(mu);
            destino.addItem(mu);

        }

        for (D_facturacion fa:
                Main.datosfac) {

            if(fa.getId_registro().equals(inicio.id_login)){

                direccion.addItem(fa);
            }
        }

        for (Credic_Cards c:
                Main.tarjetas) {

            if(c.getId_registro().equals(inicio.id_login)){

                tarjeta.addItem(c);
            }
        }
    }
}



