import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manejo_municipio {
    public JPanel Panel_municipios;
    private JComboBox<Departamento> Index_dep;
    private JTextField Nom_municipio;
    private JButton agregarButton;
    private JButton regresarButton;
    private JButton actualizarButton;
    private JTable table1;
    private JButton eliminarButton;
    private JComboBox<Municipio> R_municipios;
    private JButton irAModificacionDeButton;

    public Manejo_municipio() {
    regresarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            inicio.frame.setContentPane(new Manejo_departamento().manejo_dep);
            inicio.frame.pack();
            inicio.frame.setSize(700,700);
        }
    });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = Index_dep.getSelectedIndex();

                if(Nom_municipio.getText().length() == 0  ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                for (Municipio es : Main.municipios){

                    if (es.getNombre().equals(Nom_municipio.getText()) ){

                        JOptionPane.showMessageDialog(inicio.frame, "No es posible resitrar este Municipio!");
                        Nom_municipio.setText("");
                        return;
                    }
                }

                if(Nom_municipio.getText().length() == 0 ) {
                    JOptionPane.showMessageDialog(null, "No puede dejar datos en blanco", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Departamento cod = Main.departamentos.get(index);

                Main.municipios.add(new Municipio(cod.getCodigo(), Nom_municipio.getText(), cod));
                JOptionPane.showMessageDialog(inicio.frame, "Municipio Registrado!");

                DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();

                tableModel.setRowCount(0);

                for (Municipio m:
                     Main.municipios) {

                    String[] data = new String[2];

                    data[0] = String.valueOf(m.getDepartamento().getCodigo());
                    data[1] = m.getNombre();
                    tableModel.addRow(data);
                }

                R_municipios.removeAllItems();
                for (Municipio c :
                        Main.municipios) {

                    R_municipios.addItem(c);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = R_municipios.getSelectedIndex();
                Main.municipios.remove(index);
                R_municipios.removeAllItems();

                for (Municipio c :
                        Main.municipios) {

                    R_municipios.addItem(c);
                }
            }
        });
        irAModificacionDeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inicio.frame.setContentPane(new Modificar_municipio().M_municipio);
                inicio.frame.pack();
                inicio.frame.setSize(700,700);

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        Index_dep = new JComboBox<Departamento>();

        for (Departamento c :
                Main.departamentos) {

            Index_dep.addItem(c);
        }


        String[] columnNames = new String[] {"Codgio Departamento", "Municipio"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);

        table1 = new JTable();
        table1.setModel(model);

        R_municipios = new JComboBox<Municipio>();

        for (Municipio c :
                Main.municipios) {

            R_municipios.addItem(c);
        }


    }
}
