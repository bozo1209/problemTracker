package com.bozo.problemtracker.services;

import com.bozo.problemtracker.entities.Market;
import com.bozo.problemtracker.repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public Market getMarketById(long id){
        return marketRepository.findById(id);
    }

    public Market getMarketByName(String name){
        return marketRepository.findByName(name);
    }

    public List<String> marketGroupNamesFromMarket(){
        return marketRepository.marketGroupNamesFromMarket();
    }

    public String marketGroupNameFromMarketByMarketGroupId(long id){
        return marketRepository.marketGroupNameFromMarketByMarketGroupId(id);
    }

    public List<String> getMarketNames(){
        return marketRepository.getMarketNames();
    }
}
