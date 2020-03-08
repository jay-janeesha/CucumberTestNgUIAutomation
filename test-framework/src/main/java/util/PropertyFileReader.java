package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyFileReader.class);
    private Properties properties;

    public PropertyFileReader(String fileName) {
        properties = getData(fileName);
    }

    private Properties getData(String fileName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            FileInputStream fileInput = new FileInputStream(new File(classLoader.getResource(fileName).getFile()));
            Properties properties = new Properties();
            properties.load(fileInput);
            return properties;
        } catch (Exception e) {
            LOGGER.warn("config.properties not found. " + e.getLocalizedMessage(), e);
            Assert.fail("Failed to read property file. " + e.getLocalizedMessage(), e);
        }
        return null;
    }

    public String getProperty(String key) {
        String property = properties.getProperty(key);
        LOGGER.info("property: {} -> {}", key, property);
        return property;
    }
}
