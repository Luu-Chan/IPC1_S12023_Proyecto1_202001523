import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicio {

    private String adminuser = " ipc1_202001523@ipc1delivery.com";
    private String passuser = "202001523";

    public static String id_login ;

    public  JPanel panelogin;

    private JTextField textousuario;
    private JButton ingresarButton;
    private JButton registrarseButton;
    private JPasswordField password;
    public static JFrame frame;

    public inicio() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (Datos_usuarios re : Main.usuariosreg) {

                    if (textousuario.getText().equals(re.getCorreo()) && password.getText().equals(re.getPass())) {

                        JOptionPane.showMessageDialog(frame, "Bienvenido " + re.getAlias());

                        id_login = re.getDpi();
                        frame.setContentPane(new Panel_usuario().P_usuario);
                        frame.pack();
                        frame.setVisible(true);
                        frame.setSize(600, 500);

                        return;
                    }
                }

                if (textousuario.getText().equals(adminuser) && password.getText().equals(passuser)) {



                    frame.setContentPane(new Ventana_admin().ventana_admin);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setSize(600, 500);
                    JOptionPane.showMessageDialog(frame, "Bienvenido al Panel de Administrador");

                } else{
                    JOptionPane.showMessageDialog(frame, "Correo o Contraseña Incorrecto");
                    textousuario.setText("");
                    password.setText("");
                }
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                frame.setContentPane(new registro_usuarios().registro_usuario);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(900,500);

            }
        });
    }

    public static void main(String[] args) {

        System.out.println("Bienvenido!");

        Main.regiones.add(new Regiones("M","Metropolitana", 25.00, 35.00 ));
        Main.regiones.add(new Regiones("NT","Norte", 68.50, 45.55 ));
        Main.regiones.add(new Regiones("NO","Nororiente", 58.68, 35.48 ));
        Main.regiones.add(new Regiones("SO","Suroriente", 38.68, 32.48 ));
        Main.regiones.add(new Regiones("SOC","Suroccidente", 34.00, 29.00 ));
        Main.regiones.add(new Regiones("NOC","Noroccidente", 44.50, 40.00 ));

        Regiones region1 = Main.regiones.get(0);
        Main.departamentos.add(new Departamento(region1.getCodigo(),"Gutaepeor", region1));

        Departamento dep1 = Main.departamentos.get(0);
        Main.municipios.add(new Municipio("VN", "Villa Nueva",dep1));
        Main.usuariosreg.add(new Datos_usuarios("Luis","","TESTEO","123","123","","123","","","",""));


        frame = new JFrame("USAC-Delivery - Proyecto1");
        frame.setContentPane(new inicio().panelogin);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(600,500);

    }
}
