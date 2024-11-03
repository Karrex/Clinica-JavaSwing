package bosquehealth.ui;

import bosquehealth.service.PacienteService;
import bosquehealth.service.TurnoService;

import javax.swing.*;

public class MainFrame extends JFrame {

    private final PacienteService pacienteService;
    private final TurnoService turnoService;

    public MainFrame(PacienteService pacienteService, TurnoService turnoService) {
        this.pacienteService = pacienteService;
        this.turnoService = turnoService;

        setTitle("Sistema de Gestión de Consultas Médicas - Bosque Health");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenu();
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuPacientes = new JMenu("Pacientes");
        JMenu menuCitas = new JMenu("Citas");
        JMenu menuTurnos = new JMenu("Turnos");

        menuBar.add(menuPacientes);
        menuBar.add(menuCitas);
        menuBar.add(menuTurnos);

        JMenuItem verPacientes = new JMenuItem("Gestión de Pacientes");
        JMenuItem verCitas = new JMenuItem("Gestión de Citas");
        JMenuItem verTurnos = new JMenuItem("Gestión de Turnos");

        menuPacientes.add(verPacientes);
        menuCitas.add(verCitas);
        menuTurnos.add(verTurnos);

        PacientePanel pacientePanel = new PacientePanel(pacienteService);
        CitaPanel citaPanel = new CitaPanel(pacienteService, turnoService);
        TurnoPanel turnoPanel = new TurnoPanel(turnoService);

        verPacientes.addActionListener(e -> setContentPane(pacientePanel));
        verCitas.addActionListener(e -> setContentPane(citaPanel));
        verTurnos.addActionListener(e -> setContentPane(turnoPanel));

        setContentPane(pacientePanel);
    }
}