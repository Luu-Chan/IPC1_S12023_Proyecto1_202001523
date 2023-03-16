import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_kioskos {
    public JPanel kioskos;
    private JComboBox<Municipio> Smunicipio;
    private JTextField codigok;
    private JTextField nombrek;
    private JButton agregarButton;
    private JButton regresarButton;
    private JComboBox<Kiosko> eliminark;
    private JButton eliminarButton;
public Manejo_kioskos() {
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(nombrek.getText().length() == 0 || codigok.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Kiosko ko : Main.kioskos){

                if (ko.getCodigo().equals(codigok.getText()) && ko.getNombre().equals(nombrek.getText()) ){

                    JOptionPane.showMessageDialog(inicio.frame, "No es posible resitrar este Kiosko!");
                    nombrek.setText("");
                    codigok.setText("");
                    return;
                }
            }



            int index = Smunicipio.getSelectedIndex();

            Municipio selec = Main.municipios.get(index);

            Main.kioskos.add(new Kiosko(codigok.getText(), nombrek.getText(), selec));
            JOptionPane.showMessageDialog(inicio.frame, "Kiosko Registrado!");

            eliminark.removeAllItems();

            for (Kiosko k:
                    Main.kioskos) {

                eliminark.addItem(k);

            }




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

            int index = eliminark.getSelectedIndex();

            Main.kioskos.remove(index);
            eliminark.removeAllItems();
            for (Kiosko k:
                    Main.kioskos) {

                eliminark.addItem(k);

            }

        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        Smunicipio = new JComboBox<Municipio>();

        for (Municipio c :
                Main.municipios) {

            Smunicipio.addItem(c);
        }

        eliminark = new JComboBox<Kiosko>();

        for (Kiosko k:
             Main.kioskos) {

            eliminark.addItem(k);

        }




    }
}
