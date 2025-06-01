package ru.yandex.praktitum.tests.enums.order;


public enum ScooterColor {
  BLACK_PEARL("чёрный жемчуг"),
  GREY_HOPELESSNESS("серая безысходность");

  private final String colorName;

  ScooterColor(String colorName) {
    this.colorName = colorName;
  }

  public String getColorName() {
    return colorName;
  }
}
