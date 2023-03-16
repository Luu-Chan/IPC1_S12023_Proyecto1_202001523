import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modificacion_usuario {
    public JPanel modificar_user;
    private JTextField Nombreuser;
    private JTextField correo_usuarios;
    private JTextField alias;
    private JTextField pass_user;
    private JTextField dpi;
    private JTextField apellidouser;
    private JTextField telefono;
    private JTextField fecha_nac;
    private JComboBox rol_usuario;
    private JButton modificarButton;
    private JButton regresarButton;
    private JTextField text_genero;
    private JComboBox nacionalidad;
    private JLabel Labeluser;
    private JComboBox<Datos_usuarios> usuarios;


    public Modificacion_usuario() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


            inicio.frame.setContentPane(new Manejo_usuarios().Modificar_user);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);



        }
    });
    modificarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {



            String pass = pass_user.getText();
            Main.validarpass(pass);

            if (Main.validarpass(pass) == true) {

                for (Datos_usuarios es : Main.usuariosreg) {

                    if (es.getCorreo().equals(correo_usuarios.getText()) && es.getDpi().equals(dpi.getText()) || es.getAlias().equals(alias.getText())) {

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible resitrar este Usuario!");
                        Nombreuser.setText("");
                        alias.setText("");
                        correo_usuarios.setText("");
                        apellidouser.setText("");
                        dpi.setText("");
                        telefono.setText("");
                        fecha_nac.setText("");
                        pass_user.setText("");
                        text_genero.setText("");
                        return;
                    }
                }

                if (Nombreuser.getText().length() == 0 || correo_usuarios.getText().length() == 0 || apellidouser.getText().length() == 0 || dpi.getText().length() == 0 || text_genero.getText().length() == 0 || telefono.getText().length() == 0 || fecha_nac.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String rol = (String) rol_usuario.getSelectedItem();
                String nac = (String) nacionalidad.getSelectedItem();

                int index = usuarios.getSelectedIndex();
                Main.usuariosreg.remove(index);

                Main.usuariosreg.add(index, new Datos_usuarios(Nombreuser.getText(), apellidouser.getText(), alias.getText(), correo_usuarios.getText(), dpi.getText(), telefono.getText(), pass_user.getText(), rol, fecha_nac.getText(), nac, text_genero.getText()));
                Nombreuser.setText("");
                alias.setText("");
                correo_usuarios.setText("");
                apellidouser.setText("");
                dpi.setText("");
                telefono.setText("");
                fecha_nac.setText("");
                pass_user.setText("");
                text_genero.setText("");

                usuarios.removeAllItems();
                for (Datos_usuarios da:
                        Main.usuariosreg) {

                    usuarios.addItem(da);

                }

            } else {
                JOptionPane.showMessageDialog(inicio.frame, "La contraseña debe contener Mayusculas, Minusculas, Numeros y Caracteres especiales!");
                pass_user.setText("");
                return;

            }
        }
    });
}

    private void createUIComponents() {
        // TODO: place custom component creation code here

        usuarios = new JComboBox<Datos_usuarios>();

        for (Datos_usuarios da:
             Main.usuariosreg) {

            usuarios.addItem(da);

        }
    }
}
