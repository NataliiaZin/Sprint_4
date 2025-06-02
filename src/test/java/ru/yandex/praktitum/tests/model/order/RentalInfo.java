package ru.yandex.praktitum.tests.model.order;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import ru.yandex.praktitum.tests.enums.order.RentalPeriod;
import ru.yandex.praktitum.tests.enums.order.ScooterColor;

@Builder
@Getter
public class RentalInfo {

  private LocalDate rentalDate;
  private RentalPeriod rentalPeriod;
  private ScooterColor scooterColor;
  private String courierComment;
}
