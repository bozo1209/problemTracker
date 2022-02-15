package com.bozo.problemtracker.entities;

import com.bozo.problemtracker.enums.NoteStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "noteSeq")
    private long id;
//    @ManyToOne
//    private MarketGroup marketGroup;
    @ManyToOne
    private Market market;
    private String outsideNumber;
    private String description;
    private String status;
//    private NoteStatus status;
    private LocalDate data;
    @ManyToOne
    private Users users;

    public Note() {
    }

    public Note(Market market, String outsideNumber, String description, String status, LocalDate data, Users users) {
        this.market = market;
        this.outsideNumber = outsideNumber;
        this.description = description;
        this.status = status;
        this.data = data;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
