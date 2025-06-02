package ru.yandex.praktitum.tests.enums.order;

import lombok.Getter;

@Getter
public enum ScooterColor {
  BLACK_PEARL("чёрный жемчуг"),
  GREY_HOPELESSNESS("серая безысходность");

  private final String colorName;

  ScooterColor(String colorName) {
    this.colorName = colorName;
  }
}
