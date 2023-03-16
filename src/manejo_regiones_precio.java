import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manejo_regiones_precio {
    public JPanel regiones_precio;
    private JTextField codigo;
    private JTextField Precio_estandar;
    private JTextField region;
    private JLabel Codigo;
    private JTextField Precio_especial;
    private JButton agregarButton;
    private JButton regresarButton;
    private JComboBox<Regiones> Eliminar_region;
    private JButton eliminarButton;
    private JButton irAModificarRegionesButton;

    public manejo_regiones_precio() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if(codigo.getText().length() == 0 || Precio_estandar.getText().length() == 0 || Precio_especial.getText().length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(Double.parseDouble(Precio_estandar.getText()) <=0 || Double.parseDouble(Precio_especial.getText()) <= 0   ){

                    JOptionPane.showMessageDialog(null, "No puede poner precios Negativos o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
                    Precio_especial.setText("");
                    Precio_estandar.setText("");
                    return;

                }


                for (Regiones re : Main.regiones){

                    if (re.getCodigo().equals(codigo.getText()) && re.getNombre().equals(region.getText())) {

                            JOptionPane.showMessageDialog(inicio.frame, "No es posible registrar esta Region!");
                            codigo.setText("");
                            region.setText("");

                            return;
                    }
                }

                Main.regiones.add(new Regiones(codigo.getText(), region.getText(),Double.parseDouble(Precio_estandar.getText()), Double.parseDouble(Precio_especial.getText()) ));

                Eliminar_region.removeAllItems();
                for (Regiones c:
                        Main.regiones) {

                    Eliminar_region.addItem(c);

                }

                codigo.setText("");
                region.setText("");
                Precio_especial.setText("");
                Precio_estandar.setText("");
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                inicio.frame.setContentPane(new Ventana_admin().ventana_admin);
                inicio.frame.pack();
                inicio.frame.setVisible(true);
                inicio.frame.setSize(600,500);

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = Eliminar_region.getSelectedIndex();

                Main.regiones.remove(index);

                Eliminar_region.removeAllItems();

                for (Regiones c:
                        Main.regiones) {

                    Eliminar_region.addItem(c);
                }
            }
        });
        irAModificarRegionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Modificar_regiones().M_regiones);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        Eliminar_region = new JComboBox<Regiones>();

        for (Regiones c:
             Main.regiones) {

            Eliminar_region.addItem(c);

        }
    }
}
