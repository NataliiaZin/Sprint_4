package ru.yandex.praktitum.tests.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement findElementWaitingVisibility(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    return wait.until(
        ExpectedConditions.visibilityOfElementLocated(locator)
    );
  }

  public void waitForElementToBeClickable(WebElement element) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.elementToBeClickable(element));
  }

  public void scrollToElement(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }
}
