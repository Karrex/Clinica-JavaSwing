package bosquehealth.exceptions;

public class EspecialistaNoEncontradoException extends RuntimeException {
    public EspecialistaNoEncontradoException(String id) {
        super("Especialista con ID " + id + " no encontrado.");
    }
}