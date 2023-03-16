import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Asignar_Kiosko {
    private JComboBox<Datos_usuarios> user;
    private JComboBox<Kiosko> kiosko;
    private JButton asignarButton;
    private JButton regresarButton;
    public JPanel asignark;

    public Asignar_Kiosko() {
        asignarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(inicio.frame, "Usuario Asignado Correctamente");

            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inicio.frame.setContentPane(new Manejo_usuarios().Modificar_user);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        user = new JComboBox<Datos_usuarios>();
        kiosko = new JComboBox<Kiosko>();

        for (Datos_usuarios da:
             Main.usuariosreg) {

            user.addItem(da);
        }

        for (Kiosko ki:
             Main.kioskos) {

            kiosko.addItem(ki);
        }
    }
}
