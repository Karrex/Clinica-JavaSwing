package bosquehealth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno implements Serializable {
    private String fechaInicio;
    private String fechaFin;
    private String especialistaId;
}