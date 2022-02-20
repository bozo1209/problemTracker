package com.bozo.problemtracker.models;

import com.bozo.problemtracker.entities.Market;
import com.bozo.problemtracker.entities.Users;
import com.bozo.problemtracker.forms.NoteForm;

import java.time.LocalDate;

public class NotePresentation {

    private long id;
    private String market;
    private String outsideNumber;
    private String description;
    private String status;
    private LocalDate data;
    private String users;
    private Long count;

    public NotePresentation(long id, String market, String outsideNumber, String description, String status, LocalDate data, String users, Long count) {
        this.id = id;
        this.market = market;
        this.outsideNumber = outsideNumber;
        this.description = description;
        this.status = status;
        this.data = data;
        this.users = users;
        this.count = count;
    }

    public NotePresentation(){}

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public NoteForm convertToNoteForm(){
        NoteForm noteForm = new NoteForm();
        noteForm.setId(this.getId());
        noteForm.setMarket(this.getMarket());
        noteForm.setOutsideNumber(this.getOutsideNumber());
        noteForm.setDescription(this.getDescription());
        noteForm.setStatus(this.getStatus());
        noteForm.setYear(this.getData().getYear());
        noteForm.setMonth(this.getData().getMonthValue());
        noteForm.setDay(this.getData().getDayOfMonth());
        noteForm.setUsers(this.getUsers());
        return noteForm;
    }
}
