package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static final Properties configs;

    static {
        configs = readFromFile("/config.properties");
    }

    private static Properties readFromFile(String path) {
        Properties properties = new Properties();
        try (InputStream input = PropertyLoader.class.getResourceAsStream(path)) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Unable to load properties file " + path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading properties file " + path, e);
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
