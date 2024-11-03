package bosquehealth;


import bosquehealth.model.Especialista;
import bosquehealth.model.Paciente;
import bosquehealth.service.PacienteService;
import bosquehealth.service.TurnoService;
import bosquehealth.ui.MainFrame;
import bosquehealth.util.PropertiesLoader;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String archivoPacientes = "src/main/resources/pacientes.properties";
        String archivoEspecialistas = "src/main/resources/especialistas.properties";


        List<Paciente> pacientesList = PropertiesLoader.cargarPacientes(archivoPacientes);
        Map<String, Paciente> pacienteMap = new HashMap<>();
        pacientesList.forEach(paciente -> pacienteMap.put(paciente.getId(), paciente));

        List<Especialista> especialistasList = PropertiesLoader.cargarEspecialistas(archivoEspecialistas);
        Map<String, Especialista> especialistaMap = new HashMap<>();
        especialistasList.forEach(especialista -> especialistaMap.put(especialista.getId(), especialista));


        PacienteService pacienteService = new PacienteService(pacienteMap);
        TurnoService turnoService = new TurnoService(especialistaMap);


        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(pacienteService, turnoService);
            mainFrame.setVisible(true);
        });
    }
}