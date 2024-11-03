package bosquehealth.dao;

import bosquehealth.model.Turno;

import java.io.*;
import java.util.List;

public class TurnoDAO {

    private static final String ARCHIVO_TURNOS_BINARIO = "turnos.bin";

    public void guardarTurnos(List<Turno> turnos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_TURNOS_BINARIO))) {
            oos.writeObject(turnos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Turno> cargarTurnos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_TURNOS_BINARIO))) {
            return (List<Turno>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
