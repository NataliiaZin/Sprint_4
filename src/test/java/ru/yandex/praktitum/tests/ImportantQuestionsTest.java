package ru.yandex.praktitum.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktitum.tests.enums.ImportantQuestionsPanel;
import ru.yandex.praktitum.tests.page_object.MainPage;
import ru.yandex.praktitum.tests.properties.TestProperties;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BaseTest {

  private final ImportantQuestionsPanel importantQuestionsPanel;
  private MainPage mainPage;

  public ImportantQuestionsTest(ImportantQuestionsPanel importantQuestionsPanel) {
    this.importantQuestionsPanel = importantQuestionsPanel;
  }

  @Before
  public void setup() {
    mainPage = new MainPage(driver);
  }

  @Test
  public void validateImportantQuestionsPanelTextTest() {
    driver.get(TestProperties.getProperty("application.url"));
    String panelText = mainPage.getPanelText(importantQuestionsPanel);
    assertEquals(importantQuestionsPanel.getExpectedText(), panelText);
  }

  @Parameterized.Parameters
  public static List<Object[]> parameters() {
    return Arrays.asList(new Object[][]{
        {ImportantQuestionsPanel.COST_PANEL},
        {ImportantQuestionsPanel.FEW_SCOOTER_PANEL},
        {ImportantQuestionsPanel.RENT_SETTLEMENT_PANEL},
        {ImportantQuestionsPanel.TODAY_RENT_PANEL},
        {ImportantQuestionsPanel.RENEW_RETURN_PANEL},
        {ImportantQuestionsPanel.CHARGER_PANEL},
        {ImportantQuestionsPanel.ORDER_CANCELING_PANEL},
        {ImportantQuestionsPanel.LONG_DISTANCE_DELIVERY_PANEL}
    });
  }

}