package com.alfascoring.databaseapplication;

// Created by Regina on 20.09.2017.

import java.util.Date;

public class Appeal {
    private int clientInn;
    private Date appealDate;
    private String description = "";

    public Appeal() {

    }

    public Appeal(int clientInn, Date appealDate, String description) {
        this.clientInn = clientInn;
        this.appealDate = appealDate;
        this.description = description;
    }

    public void setClientInn(int clientInn) {
        this.clientInn = clientInn;
    }

    public int getClientInn() {
        return clientInn;
    }

    public Date getAppealDate() {
        return appealDate;
    }

    public void setAppealDate(Date appealDate) {
        this.appealDate = appealDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Appeal{" +
                "clientInn=" + clientInn +
                ", appealDate='" + appealDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
