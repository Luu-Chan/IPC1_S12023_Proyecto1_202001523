import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_userpropio {
    public JPanel datos_facturacion;
    private JButton regresarButton;
    private JButton eliminarMiUsuarioButton;
    private JButton modificarButton;

    public Manejo_userpropio() {

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Panel_usuario().P_usuario);
                inicio.frame.pack();
                inicio.frame.setVisible(true);
                inicio.frame.setSize(600, 500);

            }
        });
        eliminarMiUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });
    }

}
