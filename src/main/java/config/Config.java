package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.err.println("⚠️ Arquivo application.properties não encontrado em /resources/");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            System.err.println("❌ Erro ao carregar application.properties: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}