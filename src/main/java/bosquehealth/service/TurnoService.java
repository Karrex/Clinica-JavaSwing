package bosquehealth.service;

import bosquehealth.dao.TurnoDAO;
import bosquehealth.exceptions.EspecialistaNoEncontradoException;
import bosquehealth.model.Especialista;
import bosquehealth.model.Turno;

import java.util.List;
import java.util.Map;

public class TurnoService {
    private Map<String, Especialista> especialistaMap;

    public TurnoService(Map<String, Especialista> especialistaMap) {
        this.especialistaMap = especialistaMap;
    }

    public Especialista buscarEspecialistaPorId(String id) {
        Especialista especialista = especialistaMap.get(id);
        if (especialista == null) {
            throw new EspecialistaNoEncontradoException(id);
        }
        return especialista;
    }

    public Especialista buscarEspecialistaPorNombre(String nombre) {
        return especialistaMap.values().stream()
                .filter(especialista -> especialista.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new EspecialistaNoEncontradoException(nombre));
    }

    public void asignarTurno(String especialistaId, Turno turno) {
        Especialista especialista = buscarEspecialistaPorId(especialistaId);
        especialista.getTurnos().add(turno);
        System.out.println("Turno asignado para el especialista: " + especialista.getNombre());
    }

    public Map<String, Especialista> getEspecialistas() {
        return especialistaMap;
    }
}