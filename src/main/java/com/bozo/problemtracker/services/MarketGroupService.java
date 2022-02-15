package com.bozo.problemtracker.services;

import com.bozo.problemtracker.repositories.MarketGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketGroupService {

    private MarketGroupRepository marketGroupRepository;

    @Autowired
    public MarketGroupService(MarketGroupRepository marketGroupRepository){
        this.marketGroupRepository = marketGroupRepository;
    }

    public String findNameById(long id){
        String nameById = marketGroupRepository.findNameById(id);
        System.out.println("nameById = " + nameById);
//        for(char c : nameById.toCharArray()){
//            System.out.println(c);
//        }
        return nameById;
    }

}
