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

  public void fillUserInfoInputs(String name, String lastName, String address, String metroStation,
                          String phone, WebDriver webDriver) {
    WebElement nameInput = findElementWaitingVisibility(NAME_INPUT_XPATH, webDriver);
//    scrollToElement(nameInput, webDriver);
    nameInput.sendKeys(name);
    WebElement lastNameInput = findElementWaitingVisibility(LAST_NAME_INPUT_XPATH,
        webDriver
    );
//    scrollToElement(lastNameInput, webDriver);
    lastNameInput.sendKeys(lastName);
    WebElement addressInput = findElementWaitingVisibility(ADDRESS_INPUT_XPATH, webDriver);
//    scrollToElement(addressInput, webDriver);
    addressInput.sendKeys(address);
    WebElement metroStationInput = findElementWaitingVisibility(METRO_STATION_INPUT_XPATH,
        webDriver
    );
//    scrollToElement(metroStationInput, webDriver);
    metroStationInput.sendKeys(metroStation);
    WebElement metroStationOption = findElementWaitingVisibility(METRO_STATION_OPTION_XPATH, webDriver);
//    scrollToElement(metroStationOption, webDriver);
    metroStationOption.click();
    WebElement phoneInput = findElementWaitingVisibility(PHONE_INPUT_XPATH, webDriver);
//    scrollToElement(phoneInput, webDriver);
    phoneInput.sendKeys(phone);
  }

  public void fillRentalInfoInputs(LocalDate rentalDate, RentalPeriod rentalPeriod,
                                   ScooterColor scooterColor, String courierComment,
                                   WebDriver webDriver) {
    WebElement rentalDateInput = findElementWaitingVisibility(RENTAL_DATE_INPUT_XPATH,
        webDriver
    );
//    scrollToElement(rentalDateInput, webDriver);
    rentalDateInput.sendKeys(rentalDate.toString());
    rentalDateInput.sendKeys(Keys.ENTER);
    WebElement rentalPeriodInput = findElementWaitingVisibility(RENTAL_PERIOD_INPUT_XPATH,
        webDriver
    );
//    scrollToElement(rentalPeriodInput, webDriver);
    rentalPeriodInput.click();
    WebElement rentalPeriodOption = webDriver.findElement(
        By.xpath(String.format(RENTAL_PERIOD_OPTION_XPATH, rentalPeriod.getPeriod())));
//    scrollToElement(rentalPeriodOption, webDriver);
    rentalPeriodOption.click();
    WebElement scooterColorCheckBox = webDriver.findElement(
        By.xpath(String.format(SCOOTER_COLOR_CHECKBOX_XPATH, scooterColor.getColorName())));
//    scrollToElement(scooterColorCheckBox, webDriver);
    scooterColorCheckBox.click();
    WebElement courierCommentInput = webDriver.findElement(COURIER_COMMENT_INPUT_XPATH);
//    scrollToElement(courierCommentInput, webDriver);
    courierCommentInput.sendKeys(courierComment);
  }

  public void clickNextButton(WebDriver webDriver) {
    WebElement nextButton = webDriver.findElement(NEXT_BUTTON_XPATH);
//    scrollToElement(nextButton, webDriver);
    nextButton.click();
  }

  public void clickOrderButton(WebDriver webDriver) {
    WebElement orderButton = webDriver.findElement(MIDDLE_ORDER_BUTTON_XPATH);
//    scrollToElement(orderButton, webDriver);
    orderButton.click();
  }

  public void clickConfirmButton(WebDriver webDriver) {
    WebElement confirmButton = findElementWaitingVisibility(CONFIRM_BUTTON_XPATH, webDriver);
//    scrollToElement(confirmButton, webDriver);
    confirmButton.click();
  }

  public String getSuccessDialogHeaderText(WebDriver webDriver) {
    return findElementWaitingVisibility(SUCCESS_ORDER_DIALOG_HEADER_XPATH, webDriver).getText();
  }
}
