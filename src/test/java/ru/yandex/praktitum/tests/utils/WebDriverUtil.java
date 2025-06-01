package ru.yandex.praktitum.tests.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktitum.tests.properties.TestProperties;
import ru.yandex.praktitum.tests.enums.WebDriverType;


public class WebDriverUtil {

  public static WebDriver initWebDriver() {
    WebDriverType webDriverType = WebDriverType.valueOf(TestProperties.getProperty("test.browser"));
    switch (webDriverType) {
      case CHROME:
        String chromeDriverVersion = TestProperties.getProperty("chrome.driver.version");
        if (chromeDriverVersion != null) {
          WebDriverManager.chromedriver().browserVersion(chromeDriverVersion).setup();
        }
        else {
          WebDriverManager.chromedriver().setup();
        }
        return new ChromeDriver();
      case FIREFOX:
        String firefoxDriverVersion = TestProperties.getProperty("firefox.driver.version");
        if (firefoxDriverVersion != null) {
          WebDriverManager.firefoxdriver().browserVersion(firefoxDriverVersion).setup();
        }
        else {
          WebDriverManager.firefoxdriver().setup();
        }
        return new FirefoxDriver();
      default:
        throw new RuntimeException("Unsupported WebDriver type: " + webDriverType);
    }
  }
}
