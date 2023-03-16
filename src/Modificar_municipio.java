import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificar_municipio {
    public JPanel M_municipio;
    private JComboBox<Municipio> Municipios;
    private JComboBox<Departamento> Departamento;
    private JTextField M_nombre;
    private JButton modificarButton;
    private JButton regresarButton;
public Modificar_municipio() {
    modificarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int indexmuni = Municipios.getSelectedIndex();
            int indexdepa = Departamento.getSelectedIndex();

            Departamento cod = Main.departamentos.get(indexdepa);

            if(M_nombre.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Municipio es : Main.municipios){

                if (es.getNombre().equals(M_nombre.getText()) ){

                    JOptionPane.showMessageDialog(inicio.frame, "No es posible modificar con un nombre ya existente!");
                    M_nombre.setText("");
                    return;
                }
            }

            Main.municipios.remove(indexmuni);
            Main.municipios.add(indexmuni, new Municipio(cod.getCodigo(), M_nombre.getText(), cod) );
            JOptionPane.showMessageDialog(inicio.frame, "Municipio Modificado!");

            Municipios = new JComboBox<Municipio>();


            Municipios.removeAllItems();
            for (Municipio c :
                    Main.municipios) {

                Municipios.addItem(c);
            }



        }
    });
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new Manejo_municipio().Panel_municipios);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);

        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here


        Departamento = new JComboBox<Departamento>();

        for (Departamento c :
                Main.departamentos) {

            Departamento.addItem(c);
        }

        Municipios = new JComboBox<Municipio>();

        for (Municipio c :
                Main.municipios) {

            Municipios.addItem(c);
        }


    }
}
