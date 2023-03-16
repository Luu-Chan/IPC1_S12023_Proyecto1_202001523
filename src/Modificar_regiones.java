import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificar_regiones {
    public JPanel M_regiones;
    private JComboBox<Regiones> R_modificar;
    private JTextField nuevo_codigo;
    private JTextField nueva_region;
    private JTextField P_especial;
    private JButton modificarButton;
    private JButton regresarButton;
    private JTextField P_estandar;

    public Modificar_regiones() {
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(nuevo_codigo.getText().length() == 0 || P_estandar.getText().length() == 0 || P_especial.getText().length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(Double.parseDouble(P_estandar.getText()) <=0 || Double.parseDouble(P_especial.getText()) <= 0   ){

                    JOptionPane.showMessageDialog(null, "No puede poner precios Negativos o igual a 0", "Error", JOptionPane.ERROR_MESSAGE);
                    P_especial.setText("");
                    P_estandar.setText("");
                    return;

                }

                for (Regiones re : Main.regiones){

                    if (re.getCodigo().equals(nuevo_codigo.getText()) && re.getNombre().equals(nueva_region.getText())){

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible modificar con un codigo o nombre existente!");
                        return;
                    }
                }

                int index = R_modificar.getSelectedIndex();

                Main.regiones.remove(index);

                Main.regiones.add(index, new Regiones(nuevo_codigo.getText(), nueva_region.getText(), Double.parseDouble(P_estandar.getText()), Double.parseDouble(P_especial.getText())));

                R_modificar.removeAllItems();
                for (Regiones c :
                        Main.regiones) {

                    R_modificar.addItem(c);
                }

                nueva_region.setText("");
                nuevo_codigo.setText("");
                P_especial.setText("");
                P_estandar.setText("");


            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new manejo_regiones_precio().regiones_precio);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        R_modificar = new JComboBox<Regiones>();

        for (Regiones c :
                Main.regiones) {

            R_modificar.addItem(c);
        }


    }
}
