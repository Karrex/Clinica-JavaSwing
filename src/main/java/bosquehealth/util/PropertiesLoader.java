package bosquehealth.util;


import bosquehealth.model.Especialista;
import bosquehealth.model.Paciente;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PropertiesLoader {

    public static List<Paciente> cargarPacientes(String archivoPacientes) {
        List<Paciente> pacientes = new ArrayList<>();
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(archivoPacientes)) {
            properties.load(fis);

            for (int i = 1; properties.containsKey("paciente." + i + ".id"); i++) {
                String id = properties.getProperty("paciente." + i + ".id");
                String nombre = properties.getProperty("paciente." + i + ".nombre");
                String email = properties.getProperty("paciente." + i + ".email");
                String telefono = properties.getProperty("paciente." + i + ".telefono");
                String direccion = properties.getProperty("paciente." + i + ".direccion");

                Paciente paciente = new Paciente(id, nombre, email, telefono, direccion, new ArrayList<>(), new ArrayList<>());
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pacientes;
    }

    public static List<Especialista> cargarEspecialistas(String archivoEspecialistas) {
        List<Especialista> especialistas = new ArrayList<>();
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(archivoEspecialistas)) {
            properties.load(fis);

            for (int i = 1; properties.containsKey("especialista." + i + ".id"); i++) {
                String id = properties.getProperty("especialista." + i + ".id");
                String nombre = properties.getProperty("especialista." + i + ".nombre");
                String especialidad = properties.getProperty("especialista." + i + ".especialidad");
                String email = properties.getProperty("especialista." + i + ".email");

                Especialista especialista = new Especialista(id, nombre, especialidad, email, new ArrayList<>());
                especialistas.add(especialista);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return especialistas;
    }
}