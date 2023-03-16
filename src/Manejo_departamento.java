import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_departamento {
    public JPanel manejo_dep;
    private JComboBox<Regiones> Reg_seleccionada;
    private JTextField textField1;
    private JButton actualizarButton;
    private JButton agregarButton;
    private JButton regresarButton;
    private JButton irAMunicipiosButton;
    private JTextField codigo;
    private JTable Tabla_depa;
    private JComboBox<Departamento> Eliminar_depa;
    private JButton eliminarButton;
    private JButton irAModificarDepartamentosButton;

    public Manejo_departamento() {

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Ventana_admin().ventana_admin);
                inicio.frame.pack();
                inicio.frame.setVisible(true);
                inicio.frame.setSize(600,500);

            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(codigo.getText().length() == 0 || textField1.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (Departamento es : Main.departamentos){

                    if (es.getNombre().equals(textField1.getText()) && es.getCodigo().equals(codigo.getText())){

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible resitrar este Departamento!");
                        codigo.setText("");
                        textField1.setText("");

                        return;
                    }
                }

                int seleccion = Reg_seleccionada.getSelectedIndex();
                Regiones registro = Main.regiones.get(seleccion);


                Main.departamentos.add(new Departamento (codigo.getText(), textField1.getText(), registro));

                JOptionPane.showMessageDialog(inicio.frame, "Departamento Registrado!");

                Eliminar_depa.removeAllItems();
                for (Departamento c :
                        Main.departamentos) {

                    Eliminar_depa.addItem(c);
                }

                codigo.setText("");
                textField1.setText("");


            }
        });
        irAMunicipiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Manejo_municipio().Panel_municipios);
                inicio.frame.pack();
                inicio.frame.setVisible(true);
                inicio.frame.setSize(700,800);

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                int index = Eliminar_depa.getSelectedIndex();
                Main.departamentos.remove(index);
                Eliminar_depa.removeAllItems();

                for (Departamento c :
                        Main.departamentos) {

                    Eliminar_depa.addItem(c);
                }



            }
        });
        irAModificarDepartamentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Modificar_departamento().M_departamento);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        Reg_seleccionada = new JComboBox<Regiones>();

        for (Regiones c :
                Main.regiones) {

            Reg_seleccionada.addItem(c);
        }

        Eliminar_depa = new JComboBox<Departamento>();

        for (Departamento c :
                Main.departamentos) {

            Eliminar_depa.addItem(c);
        }







    }
}
