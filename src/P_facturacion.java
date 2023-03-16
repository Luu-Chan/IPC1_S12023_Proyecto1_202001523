import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P_facturacion {
    public JPanel facturacion;
    private JTextField nombre;
    private JTextField direccion;
    private JTextField nit;
    private JButton agregarButton;
    private JButton regresarButton;
    private JComboBox<D_facturacion> d_facturacion;
    private JButton eliminarButton;
    private JButton irAModificarDireccionesButton;

    public P_facturacion() {
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(nombre.getText().length() == 0 || direccion.getText().length() == 0 || nit.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (D_facturacion fa : Main.datosfac) {

                if (fa.getDireccion().equals(direccion.getText())) {

                    JOptionPane.showMessageDialog(inicio.frame, "No es posible agregar la Direccion");
                    direccion.setText("");
                    nit.setText("");
                    nombre.setText("");

                    return;
                }
            }


            Main.datosfac.add(new D_facturacion(nombre.getText(), direccion.getText(), nit.getText(), inicio.id_login));
            direccion.setText("");
            nit.setText("");
            nombre.setText("");

            d_facturacion.removeAllItems();

            for (D_facturacion fa:
                    Main.datosfac) {

                if(fa.getId_registro().equals(inicio.id_login)){

                    d_facturacion.addItem(fa);

                }
            }
        }
    });
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new Panel_usuario().P_usuario);
            inicio.frame.pack();
            inicio.frame.setSize(600,600);


        }
    });
    irAModificarDireccionesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new M_direccion().m_direccion);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);

        }
    });
    eliminarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int index = d_facturacion.getSelectedIndex();

            Main.datosfac.remove(index);

            d_facturacion.removeAllItems();
            for (D_facturacion fa:
                    Main.datosfac) {

                d_facturacion.addItem(fa);

            }

        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        d_facturacion = new JComboBox<D_facturacion>();

        for (D_facturacion fa:
                Main.datosfac) {

            if(fa.getId_registro().equals(inicio.id_login)){

                d_facturacion.addItem(fa);

            }
        }
    }
}
