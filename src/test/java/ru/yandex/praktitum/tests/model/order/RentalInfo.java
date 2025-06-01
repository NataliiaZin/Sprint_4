package ru.yandex.praktitum.tests.model.order;

import java.time.LocalDate;

import ru.yandex.praktitum.tests.enums.order.RentalPeriod;
import ru.yandex.praktitum.tests.enums.order.ScooterColor;


public class RentalInfo {

  private LocalDate rentalDate;
  private RentalPeriod rentalPeriod;
  private ScooterColor scooterColor;
  private String courierComment;

  public LocalDate getRentalDate() {
    return rentalDate;
  }

  public RentalInfo setRentalDate(LocalDate rentalDate) {
    this.rentalDate = rentalDate;
    return this;
  }

  public RentalPeriod getRentalPeriod() {
    return rentalPeriod;
  }

  public RentalInfo setRentalPeriod(RentalPeriod rentalPeriod) {
    this.rentalPeriod = rentalPeriod;
    return this;
  }

  public ScooterColor getScooterColor() {
    return scooterColor;
  }

  public RentalInfo setScooterColor(ScooterColor scooterColor) {
    this.scooterColor = scooterColor;
    return this;
  }

  public String getCourierComment() {
    return courierComment;
  }

  public RentalInfo setCourierComment(String courierComment) {
    this.courierComment = courierComment;
    return this;
  }
}
