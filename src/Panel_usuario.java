import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_usuario {
    public JPanel P_usuario;
    private JComboBox comboBox1;
    private JButton aceptarButton;
    private JButton regresarAlInicioButton;

    public Panel_usuario() {
    aceptarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int index = comboBox1.getSelectedIndex();

            switch (index){

                case 0:

                    inicio.frame.setContentPane(new Registro_tarjetas().Reg_tarjetas);
                    inicio.frame.pack();
                    inicio.frame.setSize(700,550);

                    break;

                case 1:

                    inicio.frame.setContentPane(new P_facturacion().facturacion);
                    inicio.frame.pack();
                    inicio.frame.setSize(700,550);


                    break;

                case 2:

                    inicio.frame.setContentPane(new Compra_cotizacion().compras_cotizacion);
                    inicio.frame.pack();
                    inicio.frame.setSize(900,700);
                    break;

                case 4:

                    inicio.frame.setContentPane(new Manejo_userpropio().datos_facturacion);
                    inicio.frame.pack();
                    inicio.frame.setSize(700,700);


                    break;

                case 3:

                    inicio.frame.setContentPane(new P_envios().envios);
                    inicio.frame.pack();
                    inicio.frame.setSize(700,700);

                    break;
            }
        }
    });
    regresarAlInicioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            inicio.frame.setContentPane(new inicio().panelogin);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);

        }
    });

    }
}
