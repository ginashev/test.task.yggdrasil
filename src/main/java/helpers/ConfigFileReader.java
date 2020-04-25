package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final String propertyFilePath = "src/test/java/resources/config/Configuration.properties";
    private Properties properties;

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getHostName() {
        String driverPath = properties.getProperty("hostName");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Host name not specified in the Configuration.properties");
    }

    public String getProtocol() {
        String driverPath = properties.getProperty("protocol");
        if (driverPath != null) return driverPath;
        else
            throw new RuntimeException("Host name not specified in the Configuration.properties");
    }
}