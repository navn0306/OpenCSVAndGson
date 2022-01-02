package com.bridge.csv;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName
    private String name;
    @CsvBindByName(column = "email")
    private String emailId;
    @CsvBindByName
    private long phone;
    @CsvBindByName
    public String country;

    public CSVUser(String name, String emailId, long phone, String country) {
        this.name = name;
        this.emailId = emailId;
        this.phone = phone;
        this.country = country;
    }

    public CSVUser() {

    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
