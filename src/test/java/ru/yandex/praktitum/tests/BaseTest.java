package ru.yandex.praktitum.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktitum.tests.utils.WebDriverUtil;


public class BaseTest {

  protected WebDriver driver;

  @Before
  public void setUp() {
    driver = WebDriverUtil.initWebDriver();
  }

  @After
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
