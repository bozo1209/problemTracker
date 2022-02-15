package com.bozo.problemtracker.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarketGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "marketGroupSeq")
    private long id;
    private String name;

    public MarketGroup() {
    }

    public MarketGroup(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MarketGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
