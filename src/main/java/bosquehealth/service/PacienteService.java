    package bosquehealth.service;

    import bosquehealth.dao.PacienteDAO;
    import bosquehealth.exceptions.PacienteNoEncontradoException;
    import bosquehealth.model.Cita;
    import bosquehealth.model.Paciente;
    import bosquehealth.util.NotificacionService;

    import java.util.Map;



    public class PacienteService {
        private Map<String, Paciente> pacienteMap;
        private PacienteDAO pacienteDAO;

        public PacienteService(Map<String, Paciente> pacienteMap) {
            this.pacienteMap = pacienteMap;
            this.pacienteDAO = new PacienteDAO();
        }

        public Paciente buscarPacientePorId(String id) {
            Paciente paciente = pacienteMap.get(id);
            if (paciente == null) {
                throw new PacienteNoEncontradoException(id);
            }
            return paciente;
        }

        public void agregarPaciente(Paciente paciente) {
            pacienteMap.put(paciente.getId(), paciente);
            pacienteDAO.guardarPacientes(pacienteMap);
            System.out.println("Paciente agregado: " + paciente.getNombre());
        }

        public void agendarCita(String pacienteId, Cita cita) {
            Paciente paciente = buscarPacientePorId(pacienteId);
            paciente.getHistorialCitas().add(cita);

            pacienteDAO.guardarPacientes(pacienteMap);

            NotificacionService.enviarCorreo(
                    paciente.getEmail(),
                    "Cita Agendada",
                    "Su cita con " + cita.getEspecialista() + " ha sido programada para el " + cita.getFecha()
            );
            System.out.println("Cita agendada para el paciente: " + paciente.getNombre());
        }

        public void cancelarCita(String pacienteId, Cita cita) {
            Paciente paciente = buscarPacientePorId(pacienteId);
            if (paciente.getHistorialCitas().remove(cita)) {

                pacienteDAO.guardarPacientes(pacienteMap);

                NotificacionService.enviarCorreo(
                        paciente.getEmail(),
                        "Cita Cancelada",
                        "Su cita con " + cita.getEspecialista() + " programada para el " + cita.getFecha() + " ha sido cancelada."
                );
                System.out.println("Cita cancelada para el paciente: " + paciente.getNombre());
            } else {
                System.out.println("La cita no se encontró en el historial de citas del paciente.");
            }
        }

        public Map<String, Paciente> getPacientes() {
            return pacienteMap;
        }
    }