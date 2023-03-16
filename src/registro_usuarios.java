import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class registro_usuarios{


    private JTextField Nombreuser;
    private JTextField correo_usuarios;
    private JTextField alias;
    private JTextField pass_user;
    private JTextField dpi;
    private JTextField apellidouser;
    private JTextField telefono;
    private JTextField fecha_nac;
    private JComboBox rol_usuario;
    private JButton registrarButton;
    private JButton regresarButton;
    public JPanel registro_usuario;
    private JComboBox nacionalidad;
    private JTextField text_genero;
    public  JPanel panelogin;

    public registro_usuarios() {
    registrarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

                String pass= pass_user.getText();
                Main.validarpass(pass);

                if(Main.validarpass(pass)== true){

                    for (Datos_usuarios es : Main.usuariosreg){

                        if (es.getCorreo().equals(correo_usuarios.getText()) && es.getDpi().equals(dpi.getText()) || es.getAlias().equals(alias.getText())){

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

                    if(Nombreuser.getText().length() == 0 || correo_usuarios.getText().length() == 0 || apellidouser.getText().length() == 0 || dpi.getText().length() ==0 || text_genero.getText().length() ==0 || telefono.getText().length() ==0 || fecha_nac.getText().length() ==0) {
                        JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    String rol = (String) rol_usuario.getSelectedItem();
                    String nac = (String) nacionalidad.getSelectedItem();


                    Main.usuariosreg.add(new Datos_usuarios(Nombreuser.getText() ,apellidouser.getText(), alias.getText(),correo_usuarios.getText(),dpi.getText(), telefono.getText(), pass_user.getText(), rol, fecha_nac.getText() ,nac,text_genero.getText()));
                    JOptionPane.showMessageDialog(inicio.frame, "Usuario Registrado!");
                    Nombreuser.setText("");
                    alias.setText("");
                    correo_usuarios.setText("");
                    apellidouser.setText("");
                    dpi.setText("");
                    telefono.setText("");
                    fecha_nac.setText("");
                    pass_user.setText("");
                    text_genero.setText("");


                }else {
                    JOptionPane.showMessageDialog(inicio.frame, "La contraseña debe contener Mayusculas, Minusculas, Numeros y Caracteres especiales!");
                    pass_user.setText("");
                    return;

                }
        }
    });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new inicio().panelogin);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);

            }
        });
    }
}
