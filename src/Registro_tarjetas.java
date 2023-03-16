import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro_tarjetas {
    public JPanel Reg_tarjetas;
    private JTextField nombre_t;
    private JTextField numero_t;
    private JTextField fecha_t;
    private JComboBox<Credic_Cards> E_tarjeta;
    private JButton agrerarButton;
    private JButton regresarButton;
    private JButton eliminarButton;
    private JButton irAModificarTarjetasButton;

    public Registro_tarjetas() {
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int idex = E_tarjeta.getSelectedIndex();

                Main.tarjetas.remove(idex);

                E_tarjeta.removeAllItems();

                for (Credic_Cards c:
                        Main.tarjetas) {

                    if(c.getId_registro().equals(inicio.id_login)){

                        E_tarjeta.addItem(c);
                    }
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Panel_usuario().P_usuario);
                inicio.frame.pack();
                inicio.frame.setVisible(true);
                inicio.frame.setSize(600, 500);

            }
        });
        agrerarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombre_t.getText().length() == 0 || fecha_t.getText().length() == 0 || numero_t.getText().length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }


                for (Credic_Cards cre : Main.tarjetas) {

                    if (cre.getNumero_tarjeta().equals(numero_t.getText())) {

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible agregar la Tarjeta");
                        nombre_t.setText("");
                        fecha_t.setText("");
                        numero_t.setText("");

                        return;
                    }
                }

                for (Datos_usuarios re : Main.usuariosreg) {

                    if (inicio.id_login.equals(re.getDpi()) ) {


                        Main.tarjetas.add(new Credic_Cards(nombre_t.getText(), fecha_t.getText(), numero_t.getText(), inicio.id_login));
                        nombre_t.setText("");
                        fecha_t.setText("");
                        numero_t.setText("");


                    }
                }

                E_tarjeta.removeAllItems();

                for (Credic_Cards c:
                     Main.tarjetas) {

                    if(c.getId_registro().equals(inicio.id_login)){

                        E_tarjeta.addItem(c);
                    }
                }
            }
        });
        irAModificarTarjetasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new M_tarjetas().modificar_tarjeta);
                inicio.frame.pack();
                inicio.frame.setSize(600,600);


            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        E_tarjeta = new JComboBox<Credic_Cards>();

        for (Credic_Cards c:
                Main.tarjetas) {

            if(c.getId_registro().equals(inicio.id_login)){

                E_tarjeta.addItem(c);
            }
        }

    }
}
