package ru.yandex.praktitum.tests.model.order;


public class UserInfo {
  
  private String firstName;
  private String lastName;
  private String address;
  private String metroStation;
  private String phoneNumber;


  public String getFirstName() {
    return firstName;
  }

  public UserInfo setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserInfo setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public UserInfo setAddress(String address) {
    this.address = address;
    return this;
  }

  public String getMetroStation() {
    return metroStation;
  }

  public UserInfo setMetroStation(String metroStation) {
    this.metroStation = metroStation;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public UserInfo setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
}
