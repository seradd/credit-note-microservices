package com.serad.creditnote.creditscoreservice.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer extends BaseEntity{

    private String tckn;
    private String name;
    private String surname;
    private Double monthlyIncome;
    private String phoneNumber;
    private Double creditScore;

    public Customer(String tckn, String name, String surname, Double monthlyIncome, String phoneNumber, Double creditScore) {
        this.tckn = tckn;
        this.name = name;
        this.surname = surname;
        this.monthlyIncome = monthlyIncome;
        this.phoneNumber = phoneNumber;
        this.creditScore = creditScore;
    }

    public Customer() {
    }

    public String getTckn() {
        return tckn;
    }

    public void setTckn(String tckn) {
        this.tckn = tckn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(Double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }
}
