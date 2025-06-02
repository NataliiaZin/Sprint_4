package ru.yandex.praktitum.tests;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktitum.tests.enums.order.RentalPeriod;
import ru.yandex.praktitum.tests.enums.order.ScooterColor;
import ru.yandex.praktitum.tests.model.order.RentalInfo;
import ru.yandex.praktitum.tests.model.order.UserInfo;
import ru.yandex.praktitum.tests.page_object.MainPage;
import ru.yandex.praktitum.tests.page_object.OrderPage;
import ru.yandex.praktitum.tests.properties.TestProperties;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

  private static final String SUCCESS_ORDER_TEXT = "Заказ оформлен";
  private final UserInfo userInfo;
  private final RentalInfo rentalInfo;
  private final boolean startFromTopOrderButton;
  private OrderPage orderPage;
  private MainPage mainPage;

  @Before
  public void setup() {
    mainPage = new MainPage(driver);
    orderPage = new OrderPage(driver);
  }

  public OrderTest(UserInfo userInfo, RentalInfo rentalInfo, boolean startFromTopOrderButton) {
    this.userInfo = userInfo;
    this.rentalInfo = rentalInfo;
    this.startFromTopOrderButton = startFromTopOrderButton;
  }

  @Test
  public void successOrderTest() {
    driver.get(TestProperties.getProperty("application.url"));
    mainPage.clickConfirmCookieButton();
    if (startFromTopOrderButton) {
      mainPage.clickOnTopOrderButton();
    }
    else {
      mainPage.clickOnMiddleOrderButton();
    }
    orderPage.fillUserInfoInputs(userInfo.getFirstName(), userInfo.getLastName(),
        userInfo.getAddress(), userInfo.getMetroStation(), userInfo.getPhoneNumber());
    orderPage.clickNextButton();
    orderPage.fillRentalInfoInputs(rentalInfo.getRentalDate(), rentalInfo.getRentalPeriod(),
        rentalInfo.getScooterColor(), rentalInfo.getCourierComment()
    );
    orderPage.clickOrderButton();
    orderPage.clickConfirmButton();
    assertTrue(orderPage.getSuccessDialogHeaderText().contains(SUCCESS_ORDER_TEXT));
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
    return UserInfo.builder()
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .metroStation(metroStation)
        .phoneNumber(phoneNumber)
        .build();
  }

  private static RentalInfo initRentalInfo(LocalDate rentalDate, RentalPeriod rentalPeriod,
                                           ScooterColor scooterColor, String courierComment) {
    return RentalInfo.builder()
        .rentalDate(rentalDate)
        .rentalPeriod(rentalPeriod)
        .scooterColor(scooterColor)
        .courierComment(courierComment)
        .build();
  }

  @After
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}