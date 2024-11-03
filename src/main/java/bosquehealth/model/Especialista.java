package bosquehealth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialista {
    private String id;
    private String nombre;
    private String especialidad;
    private String email;
    private List<Turno> turnos = new ArrayList<>();
}
