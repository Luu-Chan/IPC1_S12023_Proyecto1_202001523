import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class M_tarjetas {
    public JPanel modificar_tarjeta;
    private JComboBox<Credic_Cards> selec_t;
    private JTextField numero_t;
    private JTextField fecha_v;
    private JTextField nombre_t;
    private JButton modificarButton;
    private JButton regresarButton;
public M_tarjetas() {
    modificarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(nombre_t.getText().length() == 0 || fecha_v.getText().length() == 0 || numero_t.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Credic_Cards cre : Main.tarjetas) {

                if (cre.getNumero_tarjeta().equals(numero_t.getText())) {

                    JOptionPane.showMessageDialog(inicio.frame, "No es posible modificar la Tarjeta");
                    nombre_t.setText("");
                    fecha_v.setText("");
                    numero_t.setText("");

                    return;
                }
            }

            int index = selec_t.getSelectedIndex();


            Main.tarjetas.remove(index);

            Main.tarjetas.add(index, new Credic_Cards(nombre_t.getText(), fecha_v.getText(),numero_t.getText(), inicio.id_login));

            selec_t.removeAllItems();

            for (Credic_Cards c:
                    Main.tarjetas) {

                if(c.getId_registro().equals(inicio.id_login)){

                    selec_t.addItem(c);
                }
            }

            nombre_t.setText("");
            fecha_v.setText("");
            numero_t.setText("");
        }
    });
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new Registro_tarjetas().Reg_tarjetas);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);


        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        selec_t = new JComboBox<Credic_Cards>();


        for (Credic_Cards c:
                Main.tarjetas) {

            if(c.getId_registro().equals(inicio.id_login)){

                selec_t.addItem(c);
            }
        }
    }
}
