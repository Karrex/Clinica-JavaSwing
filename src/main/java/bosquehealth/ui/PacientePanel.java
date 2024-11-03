package bosquehealth.ui;

import bosquehealth.model.Paciente;
import bosquehealth.service.PacienteService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PacientePanel extends JPanel {

    private PacienteService pacienteService;
    private JTextField nombreField;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField direccionField;
    private JTextArea listaPacientesArea;

    public PacientePanel(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Datos del Paciente"));

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        formPanel.add(telefonoField);

        formPanel.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        formPanel.add(direccionField);

        JButton agregarButton = new JButton("Agregar Paciente");
        agregarButton.addActionListener(e -> agregarPaciente());
        formPanel.add(agregarButton);

        add(formPanel, BorderLayout.NORTH);

        listaPacientesArea = new JTextArea();
        listaPacientesArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(listaPacientesArea);
        add(scrollPane, BorderLayout.CENTER);

        mostrarListaPacientes();
    }

    private void agregarPaciente() {
        String nombre = nombreField.getText();
        String email = emailField.getText();
        String telefono = telefonoField.getText();
        String direccion = direccionField.getText();

        Paciente nuevoPaciente = new Paciente(String.valueOf(pacienteService.getPacientes().size() + 1),
                nombre, email, telefono, direccion,
                new ArrayList<>(), new ArrayList<>());
        pacienteService.agregarPaciente(nuevoPaciente);

        listaPacientesArea.append("Paciente agregado: " + nombre + ", " + email + ", " + telefono + ", " + direccion + "\n");

        nombreField.setText("");
        emailField.setText("");
        telefonoField.setText("");
        direccionField.setText("");
    }

    private void mostrarListaPacientes() {
        listaPacientesArea.setText(""); // Limpiar el área de texto
        for (Paciente paciente : pacienteService.getPacientes().values()) {
            listaPacientesArea.append(paciente.toString() + "\n");
        }
    }
}