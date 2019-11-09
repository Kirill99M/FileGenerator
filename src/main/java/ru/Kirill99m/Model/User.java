package ru.Kirill99m.Model;

import ru.Kirill99m.Repository.UserData;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class User {
    private String firstName;
    private String lastName;
    private String secondName;
    private int age;
    private String hometown;
    private String gender;
    private String birthDate;
    private int index;
    private String country;
    private String region;
    private String city;
    private String street;
    private int homeNumber;
    private int flat;

    public User() {
        UserData.UseApi();
        hometown = UserData.getHometown();
        index = UserData.getIndex();
        homeNumber = UserData.getHomeNumber();
        flat = UserData.getFlatNumber();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDay = UserData.getBirthDate();
        birthDate = birthDay.format(formatters);
        age = Period.between(birthDay, LocalDate.now()).getYears();
        gender = UserData.getGender();
        firstName = UserData.getFirstName();
        lastName = UserData.getLastName();
        secondName = UserData.getSecondName();
        city = UserData.getCity();
        region = UserData.getRegion();
        country = UserData.getCountry();
        street = UserData.getStreet();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHometown() {
        return hometown;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public int getIndex() {
        return index;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public int getFlat() {
        return flat;
    }
}
