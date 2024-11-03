package bosquehealth.util;

public class NotificacionService {

    public static void enviarCorreo(String destinatario, String asunto, String mensaje) {
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);

    }
}