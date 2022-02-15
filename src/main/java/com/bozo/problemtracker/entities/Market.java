package com.bozo.problemtracker.entities;

import javax.persistence.*;

@Entity
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "marketSeq")
    private long id;
    private String name;
    @ManyToOne
    private MarketGroup marketGroup;

    public Market() {
    }

    public Market(String name, MarketGroup marketGroup) {
        this.name = name;
        this.marketGroup = marketGroup;
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

    public MarketGroup getMarketGroup() {
        return marketGroup;
    }

    public void setMarketGroup(MarketGroup marketGroup) {
        this.marketGroup = marketGroup;
    }
}
