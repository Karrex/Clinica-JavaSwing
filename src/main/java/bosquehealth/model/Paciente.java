package bosquehealth.model;

import bosquehealth.util.NotificacionService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Paciente implements Serializable {
    private String id;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    private List<Cita> historialCitas = new ArrayList<>();
    private List<Tratamiento> tratamientos = new ArrayList<>();

    public Paciente(String number, String juanPerez, String mail, String number1, String s) {
    }
}
