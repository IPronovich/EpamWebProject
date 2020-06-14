package by.epam.pronovich.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PropertiesUtil {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    private static void loadProperties() {
        try {
            InputStream resourceAsStream = PropertiesUtil.class.getClassLoader()
                    .getResourceAsStream("application.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
