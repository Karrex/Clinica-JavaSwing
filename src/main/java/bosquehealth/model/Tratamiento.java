package bosquehealth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tratamiento implements Serializable {
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
}