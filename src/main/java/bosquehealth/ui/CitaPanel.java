package bosquehealth.ui;


import bosquehealth.exceptions.EspecialistaNoEncontradoException;
import bosquehealth.exceptions.PacienteNoEncontradoException;
import bosquehealth.service.PacienteService;
import bosquehealth.service.TurnoService;

import javax.swing.*;
import java.awt.*;

public class CitaPanel extends JPanel {

    private PacienteService pacienteService;
    private TurnoService turnoService;
    private JTextField pacienteIdField;
    private JTextField fechaField;
    private JTextField especialistaField;
    private JTextArea listaCitasArea;

    public CitaPanel(PacienteService pacienteService, TurnoService turnoService) {
        this.pacienteService = pacienteService;
        this.turnoService = turnoService;

        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Datos de la Cita"));

        formPanel.add(new JLabel("ID del Paciente:"));
        pacienteIdField = new JTextField();
        formPanel.add(pacienteIdField);

        formPanel.add(new JLabel("Fecha:"));
        fechaField = new JTextField();
        formPanel.add(fechaField);

        formPanel.add(new JLabel("Especialista:"));
        especialistaField = new JTextField();
        formPanel.add(especialistaField);

        JButton agendarButton = new JButton("Agendar Cita");
        agendarButton.addActionListener(e -> agendarCita());
        formPanel.add(agendarButton);

        add(formPanel, BorderLayout.NORTH);

        listaCitasArea = new JTextArea();
        listaCitasArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaCitasArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void agendarCita() {
        String pacienteId = pacienteIdField.getText();
        String fecha = fechaField.getText();
        String especialista = especialistaField.getText();

        try {
            pacienteService.buscarPacientePorId(pacienteId);

            turnoService.buscarEspecialistaPorNombre(especialista);

            listaCitasArea.append("Cita agendada para el paciente ID " + pacienteId + " con " + especialista + " en la fecha " + fecha + "\n");

            pacienteIdField.setText("");
            fechaField.setText("");
            especialistaField.setText("");

        } catch (PacienteNoEncontradoException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Paciente no encontrado", JOptionPane.ERROR_MESSAGE);
        } catch (EspecialistaNoEncontradoException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Especialista no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}