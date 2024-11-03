package bosquehealth.exceptions;

public class PacienteNoEncontradoException extends RuntimeException {
    public PacienteNoEncontradoException(String id) {
        super("Paciente con ID " + id + " no encontrado.");
    }
}