package ru.yandex.praktitum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktitum.tests.page_object.MainPage;
import ru.yandex.praktitum.tests.properties.TestProperties;
import ru.yandex.praktitum.tests.utils.WebDriverUtil;

import static org.junit.Assert.assertEquals;

public class ImportantQuestionsTest {

  private WebDriver driver;
  private MainPage mainPage;

  @Before
  public void setup() {
    driver = WebDriverUtil.initWebDriver();
    mainPage = new MainPage();
  }

  @Test
  public void validateImportantQuestionsPanelText() {
    driver.get(TestProperties.getProperty("application.url"));
    String costHeadingText = mainPage.getCostPanelText(driver);
    assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", costHeadingText);

    String fewScooterPanelText = mainPage.getFewScooterPanelText(driver);
    assertEquals(
        "Пока что у нас так: один заказ — один самокат."
        + " Если хотите покататься с друзьями, "
        + "можете просто сделать несколько заказов — один за другим.",
        fewScooterPanelText
    );

    String rentSettlementPanelText = mainPage.getRentSettlementPanelText(driver);
    assertEquals(
        "Допустим, вы оформляете заказ на 8 мая. "
        + "Мы привозим самокат 8 мая в течение дня. "
        + "Отсчёт времени аренды начинается с момента, "
        + "когда вы оплатите заказ курьеру. "
        + "Если мы привезли самокат 8 мая в 20:30, "
        + "суточная аренда закончится 9 мая в 20:30.",
        rentSettlementPanelText
    );

    String todayRentPanelText = mainPage.getTodayRentPanelText(driver);
    assertEquals(
        "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
        todayRentPanelText
    );

    String renewReturnPanelText = mainPage.getRenewReturnPanelText(driver);
    assertEquals(
        "Пока что нет! "
        + "Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
        renewReturnPanelText
    );

    String chargerPanelText = mainPage.getChargerPanelText(driver);
    assertEquals("Самокат приезжает к вам с полной зарядкой. "
                 + "Этого хватает на восемь суток — даже если будете кататься без передышек и во сне."
                 + " Зарядка не понадобится.",
        chargerPanelText
    );

    String orderCancelingPanelText = mainPage.getOrderCancelingPanelText(driver);
    assertEquals("Да, пока самокат не привезли."
                 + " Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
        orderCancelingPanelText
    );

    String longDistanceDeliveryPanelText = mainPage.getLongDistanceDeliveryPanelText(driver);
    assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.",
        longDistanceDeliveryPanelText
    );
  }

  @After
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}