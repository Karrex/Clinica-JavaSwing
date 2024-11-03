package bosquehealth.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
    private Properties properties;

    public Configuracion(String archivo) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(archivo)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getDiasRecordatorio() {
        return Integer.parseInt(properties.getProperty("recordatorio.dias"));
    }

}
