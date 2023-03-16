import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class M_direccion {
    public JPanel m_direccion;
    private JComboBox<D_facturacion> dato_selec;
    private JTextField nombre;
    private JTextField direccion;
    private JTextField nit;
    private JButton modificarButton;
    private JButton regresarbuttom;

    public M_direccion() {
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nombre.getText().length() == 0 || direccion.getText().length() == 0 || nit.getText().length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (D_facturacion fa : Main.datosfac) {

                    if (fa.getDireccion().equals(direccion.getText())) {

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible modficar  los datos");
                        direccion.setText("");
                        nit.setText("");
                        nombre.setText("");

                        return;
                    }
                }

                int index = dato_selec.getSelectedIndex();
                Main.datosfac.remove(index);

                Main.datosfac.add(index, new D_facturacion(nombre.getText(), direccion.getText(), nit.getText(), inicio.id_login));

                dato_selec.removeAllItems();

                for (D_facturacion fa:
                        Main.datosfac) {

                    if(fa.getId_registro().equals(inicio.id_login)){

                        dato_selec.addItem(fa);

                    }
                }
            }
        });
        regresarbuttom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new P_facturacion().facturacion);
                inicio.frame.pack();
                inicio.frame.setSize(600,600);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        dato_selec = new JComboBox<D_facturacion>();

        for (D_facturacion fa:
                Main.datosfac) {

            if(fa.getId_registro().equals(inicio.id_login)){

                dato_selec.addItem(fa);

            }
        }
    }
}
