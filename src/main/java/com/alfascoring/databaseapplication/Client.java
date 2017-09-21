package com.alfascoring.databaseapplication;

// Created by Regina on 20.09.2017.

public class Client {
    private int clientInn;
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private String birthday = "";
    private String passportSeries = "";
    private String passportNumber = "";
    private String actualAddress = "";
    private String registerAddress = "";

    public Client() {

    }

    public Client(int clientInn, String firstName, String lastName, String middleName, String birthday, String passportSeries, String passportNumber, String actualAddress, String registerAddress) {
        this.clientInn = clientInn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.actualAddress = actualAddress;
        this.registerAddress = registerAddress;
    }

    public void setClientInn(int clientInn) {
        this.clientInn = clientInn;
    }

    public int getClientInn() {
        return clientInn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getActualAddress() {
        return actualAddress;
    }

    public void setActualAddress(String actualAddress) {
        this.actualAddress = actualAddress;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "INN=" + clientInn +
                ", FIO='" + lastName + firstName + middleName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", Passport='" + passportSeries + " " + passportNumber + '\'' +
                ", Actual Address='" + actualAddress + '\'' +
                ", Registration Address='" + registerAddress + '\'' +
                '}';
    }
}
