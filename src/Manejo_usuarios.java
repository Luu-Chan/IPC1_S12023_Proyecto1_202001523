import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_usuarios {
    private JComboBox<Datos_usuarios> users;
    private JButton elminarButton;
    private JButton irAModificarButton;
    private JButton regresarButton;
    private JComboBox roles;
    private JButton asignarButton;
    public JPanel Modificar_user;

    public Manejo_usuarios() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Ventana_admin().ventana_admin);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);

            }
        });
        irAModificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Modificacion_usuario().modificar_user);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);




            }
        });
        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(roles.getSelectedIndex() == 0){

                    inicio.frame.setContentPane(new Asignar_Kiosko().asignark);
                    inicio.frame.pack();
                    inicio.frame.setSize(700,700);
                    return;

                }

                JOptionPane.showMessageDialog(inicio.frame, "Usuario asignado Correctamente!");

            }
        });
        elminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(inicio.frame, "Usuario Eliminado Correctamente!");

                int index = users.getSelectedIndex();

                Main.usuariosreg.remove(index);
                users.removeAllItems();

                for (Datos_usuarios da:
                        Main.usuariosreg) {

                    users.addItem(da);

                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        users = new JComboBox<Datos_usuarios>();

        for (Datos_usuarios da:
             Main.usuariosreg) {

            users.addItem(da);

        }
    }
}
