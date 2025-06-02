package ru.yandex.praktitum.tests.enums.order;

import lombok.Getter;

@Getter
public enum RentalPeriod {
  DAY("сутки"),
  TWO_DAYS("двое суток"),
  THREE_DAYS("трое суток"),
  FOUR_DAYS("четверо суток"),
  FIVE_DAYS("пятеро суток"),
  SIX_DAYS("шестеро суток"),
  SEVEN_DAYS("семеро суток");

  private final String period;

  RentalPeriod(String period) {
    this.period = period;
  }
}
