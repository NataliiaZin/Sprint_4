package ru.yandex.praktitum.tests.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class TestProperties {

  private static final String PROPERTIES_FILE_PATH = "src/test/resources/test.properties";
  private static final Properties properties;

  static {
    properties = new Properties();
    try (FileInputStream input = new FileInputStream(PROPERTIES_FILE_PATH)) {
      properties.load(input);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read properties file.", e);
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
