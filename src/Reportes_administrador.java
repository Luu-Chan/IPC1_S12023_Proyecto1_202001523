import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reportes_administrador {
    public JPanel reporte_ventas;
    private JProgressBar progressBar1;
    private JButton regresarButton;

    public Reportes_administrador() {
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Ventana_admin().ventana_admin);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        progressBar1 = new JProgressBar();
        progressBar1.setValue(45);
    }
}
