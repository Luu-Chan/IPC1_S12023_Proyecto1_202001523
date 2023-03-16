import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana_admin {


    public JPanel ventana_admin;
    private JComboBox administracion;
    private JButton aceptarButton;
    private JButton regresarButton;
public Ventana_admin() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new inicio().panelogin);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);
        }
    });
    aceptarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(administracion.getSelectedItem().equals("Manejo de Kioskos")) {


                inicio.frame.setContentPane(new Manejo_kioskos().kioskos);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);


            }else if(administracion.getSelectedItem().equals("Manejo de Regiones y Precios")){

                inicio.frame.setContentPane(new manejo_regiones_precio().regiones_precio);
                inicio.frame.pack();
                inicio.frame.setSize(800,500);

            }
            else if (administracion.getSelectedItem().equals("Manejo de Departamentos y Municipios")) {

                inicio.frame.setContentPane(new Manejo_departamento().manejo_dep);
                inicio.frame.pack();
                inicio.frame.setSize(800,600);
            }
            else if (administracion.getSelectedItem().equals("Reportes")){

                inicio.frame.setContentPane(new Reportes_administrador().reporte_ventas);
                inicio.frame.pack();
                inicio.frame.setSize(500,500);

            } else if (administracion.getSelectedItem().equals("Manejo de Usuarios")) {

                inicio.frame.setContentPane(new Manejo_usuarios().Modificar_user);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);

            }


        }
    });
}
}
