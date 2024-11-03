package bosquehealth.ui;

import bosquehealth.service.TurnoService;

import javax.swing.*;
import java.awt.*;

public class TurnoPanel extends JPanel {

    private JTextField especialistaIdField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextArea listaTurnosArea;

    public TurnoPanel(TurnoService turnoService) {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Datos del Turno"));

        formPanel.add(new JLabel("ID del Especialista:"));
        especialistaIdField = new JTextField();
        formPanel.add(especialistaIdField);

        formPanel.add(new JLabel("Fecha de Inicio:"));
        fechaInicioField = new JTextField();
        formPanel.add(fechaInicioField);

        formPanel.add(new JLabel("Fecha de Fin:"));
        fechaFinField = new JTextField();
        formPanel.add(fechaFinField);

        JButton asignarButton = new JButton("Asignar Turno");
        asignarButton.addActionListener(e -> asignarTurno());
        formPanel.add(asignarButton);

        add(formPanel, BorderLayout.NORTH);

        listaTurnosArea = new JTextArea();
        listaTurnosArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaTurnosArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void asignarTurno() {
        String especialistaId = especialistaIdField.getText();
        String fechaInicio = fechaInicioField.getText();
        String fechaFin = fechaFinField.getText();

        listaTurnosArea.append("Turno asignado para el especialista ID " + especialistaId + " desde " + fechaInicio + " hasta " + fechaFin + "\n");

        especialistaIdField.setText("");
        fechaInicioField.setText("");
        fechaFinField.setText("");
    }
}