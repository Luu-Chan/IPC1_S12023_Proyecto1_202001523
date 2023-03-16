import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificar_departamento {
    public JPanel M_departamento;
    private JComboBox<Departamento> Selec_departamento;
    private JTextField nuevo_cod;
    private JTextField nuevo_nombre;
    private JComboBox<Regiones> nueva_region;
    private JButton modificarButton;
    private JButton regresarButton;
public Modificar_departamento() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new Manejo_departamento().manejo_dep);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);

        }
    });
    modificarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(nuevo_cod.getText().length() == 0 || nuevo_nombre.getText().length() == 0 ) {
                JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (Departamento es : Main.departamentos){

                if (es.getCodigo().equals(nuevo_cod.getText()) && es.getNombre().equals(nuevo_nombre.getText()) ){

                    JOptionPane.showMessageDialog(inicio.frame, "No es posible modificar el departamento con un nombre existente!");
                    nuevo_nombre.setText("");
                    nuevo_cod.setText("");
                    return;
                }
            }


            int indexre = nueva_region.getSelectedIndex();
            int indexde = Selec_departamento.getSelectedIndex();

            Main.departamentos.remove(indexde);
            Regiones reg = Main.regiones.get(indexre);

            Main.departamentos.add(indexde, new Departamento(nuevo_cod.getText(), nuevo_nombre.getText(), reg));
            JOptionPane.showMessageDialog(inicio.frame, "Departamento Modificado!");


            Selec_departamento.removeAllItems();

            for (Departamento c :
                    Main.departamentos) {

                Selec_departamento.addItem(c);
            }

        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        nueva_region = new JComboBox<Regiones>();

        for (Regiones c :
                Main.regiones) {

            nueva_region.addItem(c);
        }

        Selec_departamento = new JComboBox<Departamento>();

        for (Departamento c :
                Main.departamentos) {

            Selec_departamento.addItem(c);
        }


    }
}
