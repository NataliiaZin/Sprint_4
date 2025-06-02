package ru.yandex.praktitum.tests.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.praktitum.tests.enums.ImportantQuestionsPanel;

public class MainPage extends BasePage {

    private final static By COST_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-0\"]");
    private final static By COST_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-0\"]/p");
    private final static By FEW_SCOOTER_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-1\"]");
    private final static By FEW_SCOOTER_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-1\"]/p");
    private final static By RENT_SETTLEMENT_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-2\"]");
    private final static By RENT_SETTLEMENT_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-2\"]/p");
    private final static By TODAY_RENT_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-3\"]");
    private final static By TODAY_RENT_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-3\"]/p");
    private final static By RENEW_RETURN_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-4\"]");
    private final static By RENEW_RETURN_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-4\"]/p");
    private final static By CHARGER_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-5\"]");
    private final static By CHARGER_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-5\"]/p");
    private final static By ORDER_CANCELING_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-6\"]");
    private final static By ORDER_CANCELING_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-6\"]/p");
    private final static By LONG_DISTANCE_DELIVERY_HEADING_XPATH = By.xpath("//*[@id=\"accordion__heading-7\"]");
    private final static By LONG_DISTANCE_DELIVERY_PANEL_XPATH = By.xpath("//*[@id=\"accordion__panel-7\"]/p");
    private final static By TOP_ORDER_BUTTON_XPATH = By.xpath("//button[contains(@class,'Button_Button') and text()='Заказать']");
    private final static By MIDDLE_ORDER_BUTTON_XPATH = By.xpath("//button[contains(@class,'Button_Middle') and text()='Заказать']");
    private static final By COOKIE_BUTTON_XPATH = By.xpath("//button[contains(@class, 'App_CookieButton') and text()='да все привыкли']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getPanelText(ImportantQuestionsPanel importantQuestionsPanel) {
      switch (importantQuestionsPanel) {
        case COST_PANEL:
          return getCostPanelText();
        case CHARGER_PANEL:
          return getChargerPanelText();
        case TODAY_RENT_PANEL:
          return getTodayRentPanelText();
        case FEW_SCOOTER_PANEL:
          return getFewScooterPanelText();
        case RENEW_RETURN_PANEL:
          return getRenewReturnPanelText();
        case LONG_DISTANCE_DELIVERY_PANEL:
          return getLongDistanceDeliveryPanelText();
        case ORDER_CANCELING_PANEL:
          return getOrderCancelingPanelText();
        case RENT_SETTLEMENT_PANEL:
          return getRentSettlementPanelText();
        default: throw new RuntimeException("Unkown important questions panel received. Name: " + importantQuestionsPanel.name());
      }
    }

    private String getCostPanelText() {
        WebElement costHeadingElement = driver.findElement(COST_HEADING_XPATH);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", costHeadingElement);
        waitForElementToBeClickable(costHeadingElement);
        costHeadingElement.click();
        return findElementWaitingVisibility(COST_PANEL_XPATH).getText();
    }

    private String getFewScooterPanelText() {
        WebElement fewScooterHeadingElement = driver.findElement(FEW_SCOOTER_HEADING_XPATH);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fewScooterHeadingElement);
        waitForElementToBeClickable(fewScooterHeadingElement);
        fewScooterHeadingElement.click();
        return findElementWaitingVisibility(FEW_SCOOTER_PANEL_XPATH).getText();
    }

    private String getRentSettlementPanelText() {
        WebElement rentSettlementHeadingElement = driver.findElement(RENT_SETTLEMENT_HEADING_XPATH);
        scrollToElement(rentSettlementHeadingElement);
        waitForElementToBeClickable(rentSettlementHeadingElement);
        rentSettlementHeadingElement.click();
        return findElementWaitingVisibility(RENT_SETTLEMENT_PANEL_XPATH).getText();
    }

    private String getTodayRentPanelText() {
        WebElement todayRentHeadingElement = driver.findElement(TODAY_RENT_HEADING_XPATH);
        scrollToElement(todayRentHeadingElement);
        waitForElementToBeClickable(todayRentHeadingElement);
        todayRentHeadingElement.click();
        return findElementWaitingVisibility(TODAY_RENT_PANEL_XPATH).getText();
    }

    private String getRenewReturnPanelText() {
        WebElement renewReturnHeadingElement = driver.findElement(RENEW_RETURN_HEADING_XPATH);
        scrollToElement(renewReturnHeadingElement);
        waitForElementToBeClickable(renewReturnHeadingElement);
        renewReturnHeadingElement.click();
        return findElementWaitingVisibility(RENEW_RETURN_PANEL_XPATH).getText();
    }

    private String getChargerPanelText() {
        WebElement chargerHeadingElement = driver.findElement(CHARGER_HEADING_XPATH);
        scrollToElement(chargerHeadingElement);
        waitForElementToBeClickable(chargerHeadingElement);
        chargerHeadingElement.click();
        return findElementWaitingVisibility(CHARGER_PANEL_XPATH).getText();
    }

    private String getOrderCancelingPanelText() {
        WebElement orderCancelingHeadingElement = driver.findElement(ORDER_CANCELING_HEADING_XPATH);
        scrollToElement(orderCancelingHeadingElement);
        waitForElementToBeClickable(orderCancelingHeadingElement);
        orderCancelingHeadingElement.click();
        return findElementWaitingVisibility(ORDER_CANCELING_PANEL_XPATH).getText();
    }

    private String getLongDistanceDeliveryPanelText() {
        WebElement longDistanceDeliveryHeadingElement = driver.findElement(LONG_DISTANCE_DELIVERY_HEADING_XPATH);
        scrollToElement(longDistanceDeliveryHeadingElement);
        waitForElementToBeClickable(longDistanceDeliveryHeadingElement);
        longDistanceDeliveryHeadingElement.click();
        return findElementWaitingVisibility(LONG_DISTANCE_DELIVERY_PANEL_XPATH).getText();
    }

    public void clickOnTopOrderButton() {
        WebElement topOrderButton = findElementWaitingVisibility(TOP_ORDER_BUTTON_XPATH);
        scrollToElement(topOrderButton);
        topOrderButton.click();
    }

    public void clickOnMiddleOrderButton() {
        WebElement middleButton = findElementWaitingVisibility(MIDDLE_ORDER_BUTTON_XPATH);
        scrollToElement(middleButton);
        waitForElementToBeClickable(middleButton);
        middleButton.click();
    }

    public void clickConfirmCookieButton() {
        WebElement confirmCookieButton = findElementWaitingVisibility(COOKIE_BUTTON_XPATH);
        confirmCookieButton.click();
    }
}
