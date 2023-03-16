import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class P_envios {
    public JPanel envios;
    private JTable table1;
    private JButton descargarGuiaButton;
    private JComboBox<Ventas> box_envios;
    private JButton regresarButton;
    private JButton descargarFacturaButton;


    public P_envios() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Panel_usuario().P_usuario);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);

            }
        });
        descargarFacturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = box_envios.getSelectedIndex();

                Ventas ve = Main.venta.get(index);

                FileWriter fileWriter = null;
                try {
                    // Crear un nuevo archivo .html
                    fileWriter = new FileWriter("Factura.html");

                    // Escribir contenido en el archivo
                    fileWriter.write("<html><head><title> Factura .html</title></head><body> \n");

                        fileWriter.write("<head> <title> </title> </head>\n" );

                        fileWriter.write("<h1>"+"Factura" +"</h1>");
                        fileWriter.write("<h3>" + "USAC-Delivery"+ "</h3>");
                        fileWriter.write("<p>" + "-----------------------------------------------------------------"+ "</p>");

                        fileWriter.write("<h3>" + "Datos del Cliente"+ "</h3>");
                        fileWriter.write("<p>"+ "Guia: "+ve.getId_paquete()+"</p>");
                        fileWriter.write("<p>" + "Envia: : " + ve.getDireccion()+ "</p>");
                        fileWriter.write("<p>" + "Origen: " + ve.getOrigen()+ "</p>");
                        fileWriter.write("<p>" + "Destino: " + ve.getDestino()+ "</p>");

                        fileWriter.write("<p>" + "-----------------------------------------------------------------"+ "</p>");

                        fileWriter.write("<h3>" + "Datos del Envio"+ "</h3>");
                        fileWriter.write("<p>" + "Tipo de Pago: " + ve.getMetodo_pago()+ "</p>");
                        fileWriter.write("<p>" + "Cantidad de Paquetes: " + ve.getCantidad()+ "</p>");
                        fileWriter.write("<p>" + "Tamaño del Paquete: " + ve.getTamanio()+ "</p>");
                        fileWriter.write("<p>" + "------------------------------------"+ "</p>");
                        fileWriter.write("<h3>" + "Total a Pagar: Q" + ve.getTotalpago()+ "</h3>");

                    fileWriter.write(    "</body></html>");

                    fileWriter.close();

                    System.out.println("El archivo ha sido creado y escrito con éxito.");

                } catch (IOException error) {
                    error.printStackTrace();
                }
            }


        });
        descargarGuiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = box_envios.getSelectedIndex();

                Ventas ve = Main.venta.get(index);

                FileWriter fileWriter = null;
                try {
                    // Crear un nuevo archivo .html
                    fileWriter = new FileWriter("Guia.html");

                    // Escribir contenido en el archivo
                    fileWriter.write("<html><head><title> Guia.html</title></head><body> \n");

                    fileWriter.write("<head> <title> </title> </head>\n" );
                    fileWriter.write("<h1>"+"Guia" +"</h1>");
                    fileWriter.write("<p>" + "------------------------------------------------------------------------------------------------"+ "</p>");

                    fileWriter.write("<h3>" + "Datos del Cliente"+ "</h3>");

                    fileWriter.write("<p>" + "Envia: : " + ve.getDireccion()+ "</p>");
                    fileWriter.write("<p>" + "Origen: " + ve.getOrigen()+ "</p>");
                    fileWriter.write("<p>" + "Destino: " + ve.getDestino()+ "</p>");


                    fileWriter.write("<h3>"+ "Numero de Guia: "+ve.getId_paquete()+"</h3>");
                    fileWriter.write("<div>"
                            + "<img src=\"cod_barras.svg\" alt=\"Código de barras\">\n"
                            + "</div>" );

                    fileWriter.write("<p>" + "-----------------------------------------------------------------------------------------------"+ "</p>");
                    fileWriter.write("<p>" + "Guarde esto en un lugar seguro al momento de imprimirlo"+ "</p>");
                    fileWriter.write("<p>" + "La fecha de envio esta sujeta a cambios"+ "</p>");

                    fileWriter.write(    "</body></html>");

                    fileWriter.close();

                    System.out.println("El archivo ha sido creado y escrito con éxito.");

                } catch (IOException error) {
                    error.printStackTrace();
                }
            }


        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        String[] columnNames = new String[] {"Codigo Paquete", "Destinatario", "Total a Pagar","Tipo de Pago"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table1 = new JTable();
        table1.setModel(model);


        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

        tableModel.setRowCount(0);

        for (Ventas ve:
                Main.venta) {

            String[] data = new String[4];

            data[0] = ve.getId_paquete();
            data[1] = ve.getDestino();
            data[2] = String.valueOf(ve.getTotalpago());
            data[3] = ve.getMetodo_pago();

            tableModel.addRow(data);
        }

        box_envios = new JComboBox<Ventas>();

        for (Ventas ve:
             Main.venta) {

            if(inicio.id_login.equals(ve.getId_compra())){

               box_envios.addItem(ve);

            }
        }
    }
}
