package ru.yandex.praktitum.tests.model.order;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserInfo {

  private String firstName;
  private String lastName;
  private String address;
  private String metroStation;
  private String phoneNumber;
}