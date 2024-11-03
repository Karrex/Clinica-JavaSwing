package bosquehealth.dao;

import bosquehealth.model.Paciente;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PacienteDAO {
    private static final String ARCHIVO_PACIENTES_BINARIO = "pacientes.bin";

    public void guardarPacientes(Map<String, Paciente> pacienteMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PACIENTES_BINARIO))) {
            oos.writeObject(pacienteMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Paciente> cargarPacientes() {
        File archivo = new File(ARCHIVO_PACIENTES_BINARIO);
        if (!archivo.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Map<String, Paciente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}