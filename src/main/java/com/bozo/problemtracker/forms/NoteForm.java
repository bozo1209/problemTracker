package com.bozo.problemtracker.forms;

import com.bozo.problemtracker.entities.Market;

public class NoteForm {

    private long id;
    private String market;
    private String outsideNumber;
    private String description;
    private String status;
    private int year;
    private int month;
    private int day;
    private String users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getOutsideNumber() {
        return outsideNumber;
    }

    public void setOutsideNumber(String outsideNumber) {
        this.outsideNumber = outsideNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "NoteForm{" +
                "id=" + id +
                ", market='" + market + '\'' +
                ", outsideNumber='" + outsideNumber + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", users='" + users + '\'' +
                '}';
    }
}
