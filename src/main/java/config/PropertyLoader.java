package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final Properties configs;

    static {
        configs = readFromFile();
    }

    private static Properties readFromFile() {
        Properties properties = new Properties();
        try (InputStream input = PropertyLoader.class.getResourceAsStream("/config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Unable to load properties file " + "/config.properties");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file " + "/config.properties", e);
        }
        return properties;
    }

    public static String getProperty(String key) {
        String property = System.getProperty(key);
        if (property == null || property.isEmpty()) {
            property = configs.getProperty(key);
        }
        System.out.println("Getting property " + key + ": " + property);
        return property;
    }
}
