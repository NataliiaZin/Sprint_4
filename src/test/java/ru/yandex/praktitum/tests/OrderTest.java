package ru.yandex.praktitum.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktitum.tests.enums.order.RentalPeriod;
import ru.yandex.praktitum.tests.enums.order.ScooterColor;
import ru.yandex.praktitum.tests.model.order.RentalInfo;
import ru.yandex.praktitum.tests.model.order.UserInfo;
import ru.yandex.praktitum.tests.page_object.MainPage;
import ru.yandex.praktitum.tests.page_object.OrderPage;
import ru.yandex.praktitum.tests.properties.TestProperties;
import ru.yandex.praktitum.tests.utils.WebDriverUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest {

  private final UserInfo userInfo;
  private final RentalInfo rentalInfo;
  private final boolean startFromTopOrderButton;
  private final MainPage mainPage = new MainPage();
  private final OrderPage orderPage = new OrderPage();
  private WebDriver driver;

  @Before
  public void setup() {
    driver = WebDriverUtil.initWebDriver();
  }

  public OrderTest(UserInfo userInfo, RentalInfo rentalInfo, boolean startFromTopOrderButton) {
    this.userInfo = userInfo;
    this.rentalInfo = rentalInfo;
    this.startFromTopOrderButton = startFromTopOrderButton;
  }

  @Test
  public void successOrderFromTopButton() {
    driver.get(TestProperties.getProperty("application.url"));
    mainPage.clickConfirmCookieButton(driver);
    if (startFromTopOrderButton) {
      mainPage.clickOnTopOrderButton(driver);
    }
    else {
      mainPage.clickOnMiddleOrderButton(driver);
    }
    orderPage.fillUserInfoInputs(userInfo.getFirstName(), userInfo.getLastName(),
        userInfo.getAddress(), userInfo.getMetroStation(), userInfo.getPhoneNumber(), driver);
    orderPage.clickNextButton(driver);
    orderPage.fillRentalInfoInputs(rentalInfo.getRentalDate(), rentalInfo.getRentalPeriod(),
        rentalInfo.getScooterColor(), rentalInfo.getCourierComment(), driver
    );
    orderPage.clickOrderButton(driver);
    orderPage.clickConfirmButton(driver);
    String expectedText = "Заказ оформлен";
    assertTrue(orderPage.getSuccessDialogHeaderText(driver).contains(expectedText));
  }

  @Parameterized.Parameters
  public static List<Object[]> parameters() {
    return Arrays.asList(new Object[][]{
        {
            initUserInfo("Анастасия", "Попова", "Удальцова 49",
                "Проспект Вернадского", "+79998887766"
            ),
            initRentalInfo(LocalDate.now(), RentalPeriod.DAY, ScooterColor.BLACK_PEARL,
                "Не звонить на дом"
            ),
            true
        },
        {
            initUserInfo("Степан", "Меньшиков", "Проспект Вернадского 6",
                "Университет", "+79992223344"
            ),
            initRentalInfo(LocalDate.now(), RentalPeriod.SEVEN_DAYS, ScooterColor.GREY_HOPELESSNESS,
                "Оставить у подъезда"),
            false
        }
    });
  }

  private static UserInfo initUserInfo(String firstName, String lastName, String address,
                               String metroStation, String phoneNumber) {
    return new UserInfo()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setAddress(address)
        .setMetroStation(metroStation)
        .setPhoneNumber(phoneNumber);
  }

  private static RentalInfo initRentalInfo(LocalDate rentalDate, RentalPeriod rentalPeriod,
                                           ScooterColor scooterColor, String courierComment) {
    return new RentalInfo()
        .setRentalDate(rentalDate)
        .setRentalPeriod(rentalPeriod)
        .setScooterColor(scooterColor)
        .setCourierComment(courierComment);
  }

  @After
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}