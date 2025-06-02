package ru.yandex.praktitum.tests.page_object;

import java.time.LocalDate;

import org.openqa.selenium.*;
import ru.yandex.praktitum.tests.enums.order.RentalPeriod;
import ru.yandex.praktitum.tests.enums.order.ScooterColor;


public class OrderPage extends BasePage {

  private static final By NAME_INPUT_XPATH = By.xpath("//input[@placeholder='* Имя']");
  private static final By LAST_NAME_INPUT_XPATH = By.xpath("//input[@placeholder='* Фамилия']");
  private static final By ADDRESS_INPUT_XPATH = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
  private static final By METRO_STATION_INPUT_XPATH = By.xpath("//input[@placeholder='* Станция метро']");
  private static final By METRO_STATION_OPTION_XPATH = By.xpath("//div[@class='select-search__select']");
  private static final By PHONE_INPUT_XPATH = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
  private static final By RENTAL_DATE_INPUT_XPATH = By.xpath("//input[@placeholder='* Когда привезти самокат']");
  private static final By RENTAL_PERIOD_INPUT_XPATH = By.xpath("//div[text()='* Срок аренды']");
  private static final By COURIER_COMMENT_INPUT_XPATH = By.xpath("//input[@placeholder='Комментарий для курьера']");
  private static final By NEXT_BUTTON_XPATH = By.xpath("//button[text()='Далее']");
  private static final By MIDDLE_ORDER_BUTTON_XPATH = By.xpath("//button[contains(@class, 'Button_Middle') and text()='Заказать']");
  private static final By CONFIRM_BUTTON_XPATH = By.xpath("//button[text()='Да']");
  private static final By SUCCESS_ORDER_DIALOG_HEADER_XPATH = By.xpath("//div[text()='Заказ оформлен']");
  private static final String RENTAL_PERIOD_OPTION_XPATH = "//div[text()='%s']";
  private static final String SCOOTER_COLOR_CHECKBOX_XPATH = "//label[text()='%s']";

  public OrderPage(WebDriver driver) {
    super(driver);
  }


  public void fillUserInfoInputs(String name, String lastName, String address, String metroStation,
                          String phone) {
    WebElement nameInput = findElementWaitingVisibility(NAME_INPUT_XPATH);
    nameInput.sendKeys(name);
    WebElement lastNameInput = findElementWaitingVisibility(LAST_NAME_INPUT_XPATH);
    lastNameInput.sendKeys(lastName);
    WebElement addressInput = findElementWaitingVisibility(ADDRESS_INPUT_XPATH);
    addressInput.sendKeys(address);
    WebElement metroStationInput = findElementWaitingVisibility(METRO_STATION_INPUT_XPATH);
    metroStationInput.sendKeys(metroStation);
    WebElement metroStationOption = findElementWaitingVisibility(METRO_STATION_OPTION_XPATH);
    metroStationOption.click();
    WebElement phoneInput = findElementWaitingVisibility(PHONE_INPUT_XPATH);
    phoneInput.sendKeys(phone);
  }

  public void fillRentalInfoInputs(LocalDate rentalDate, RentalPeriod rentalPeriod,
                                   ScooterColor scooterColor, String courierComment) {
    WebElement rentalDateInput = findElementWaitingVisibility(RENTAL_DATE_INPUT_XPATH);
    rentalDateInput.sendKeys(rentalDate.toString());
    rentalDateInput.sendKeys(Keys.ENTER);
    WebElement rentalPeriodInput = findElementWaitingVisibility(RENTAL_PERIOD_INPUT_XPATH);
    rentalPeriodInput.click();
    WebElement rentalPeriodOption = driver.findElement(
        By.xpath(String.format(RENTAL_PERIOD_OPTION_XPATH, rentalPeriod.getPeriod())));
    rentalPeriodOption.click();
    WebElement scooterColorCheckBox = driver.findElement(
        By.xpath(String.format(SCOOTER_COLOR_CHECKBOX_XPATH, scooterColor.getColorName())));
    scooterColorCheckBox.click();
    WebElement courierCommentInput = driver.findElement(COURIER_COMMENT_INPUT_XPATH);
    courierCommentInput.sendKeys(courierComment);
  }

  public void clickNextButton() {
    WebElement nextButton = driver.findElement(NEXT_BUTTON_XPATH);
    nextButton.click();
  }

  public void clickOrderButton() {
    WebElement orderButton = driver.findElement(MIDDLE_ORDER_BUTTON_XPATH);
    orderButton.click();
  }

  public void clickConfirmButton() {
    WebElement confirmButton = findElementWaitingVisibility(CONFIRM_BUTTON_XPATH);
    confirmButton.click();
  }

  public String getSuccessDialogHeaderText() {
    return findElementWaitingVisibility(SUCCESS_ORDER_DIALOG_HEADER_XPATH).getText();
  }
}
