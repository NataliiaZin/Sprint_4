package ru.yandex.praktitum.tests.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


    public String getCostPanelText(WebDriver driver) {
        WebElement costHeadingElement = driver.findElement(COST_HEADING_XPATH);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", costHeadingElement);
        costHeadingElement.click();
        return findElementWaitingVisibility(COST_PANEL_XPATH, driver).getText();
    }

    public String getFewScooterPanelText(WebDriver driver) {
        WebElement costHeadingElement = driver.findElement(FEW_SCOOTER_HEADING_XPATH);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", costHeadingElement);
        costHeadingElement.click();
        return findElementWaitingVisibility(FEW_SCOOTER_PANEL_XPATH, driver).getText();
    }

    public String getRentSettlementPanelText(WebDriver driver) {
        WebElement costHeadingElement = driver.findElement(RENT_SETTLEMENT_HEADING_XPATH);
        scrollToElement(costHeadingElement, driver);
        costHeadingElement.click();
        return findElementWaitingVisibility(RENT_SETTLEMENT_PANEL_XPATH, driver).getText();
    }

    public String getTodayRentPanelText(WebDriver driver) {
        WebElement todayRentHeadingElement = driver.findElement(TODAY_RENT_HEADING_XPATH);
        scrollToElement(todayRentHeadingElement, driver);
        todayRentHeadingElement.click();
        return findElementWaitingVisibility(TODAY_RENT_PANEL_XPATH, driver).getText();
    }

    public String getRenewReturnPanelText(WebDriver driver) {
        WebElement renewReturnHeadingElement = driver.findElement(RENEW_RETURN_HEADING_XPATH);
        scrollToElement(renewReturnHeadingElement, driver);
        renewReturnHeadingElement.click();
        return findElementWaitingVisibility(RENEW_RETURN_PANEL_XPATH, driver).getText();
    }

    public String getChargerPanelText(WebDriver driver) {
        WebElement chargerHeadingElement = driver.findElement(CHARGER_HEADING_XPATH);
        scrollToElement(chargerHeadingElement, driver);
        chargerHeadingElement.click();
        return findElementWaitingVisibility(CHARGER_PANEL_XPATH, driver).getText();
    }

    public String getOrderCancelingPanelText(WebDriver driver) {
        WebElement orderCancelingHeadingElement = driver.findElement(ORDER_CANCELING_HEADING_XPATH);
        scrollToElement(orderCancelingHeadingElement, driver);
        orderCancelingHeadingElement.click();
        return findElementWaitingVisibility(ORDER_CANCELING_PANEL_XPATH, driver).getText();
    }

    public String getLongDistanceDeliveryPanelText(WebDriver driver) {
        WebElement longDistanceDeliveryHeadingElement = driver.findElement(LONG_DISTANCE_DELIVERY_HEADING_XPATH);
        scrollToElement(longDistanceDeliveryHeadingElement, driver);
        longDistanceDeliveryHeadingElement.click();
        return findElementWaitingVisibility(LONG_DISTANCE_DELIVERY_PANEL_XPATH, driver).getText();
    }

    public void clickOnTopOrderButton(WebDriver driver) {
        WebElement topOrderButton = findElementWaitingVisibility(TOP_ORDER_BUTTON_XPATH, driver);
        scrollToElement(topOrderButton, driver);
        topOrderButton.click();
    }

    public void clickOnMiddleOrderButton(WebDriver driver) {
        WebElement middleButton = findElementWaitingVisibility(MIDDLE_ORDER_BUTTON_XPATH, driver);
        scrollToElement(middleButton, driver);
        waitForElementToBeClickable(middleButton, driver);
        middleButton.click();
    }

    public void clickConfirmCookieButton(WebDriver webDriver) {
        WebElement confirmCookieButton = findElementWaitingVisibility(COOKIE_BUTTON_XPATH, webDriver);
        confirmCookieButton.click();
    }
}
