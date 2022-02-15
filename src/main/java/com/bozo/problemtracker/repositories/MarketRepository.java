package com.bozo.problemtracker.repositories;

import com.bozo.problemtracker.entities.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {

    Market findById(long id);

    Market findByName(String name);

    @Query("SELECT mg.name FROM Market m INNER JOIN MarketGroup mg ON m.marketGroup.id = mg.id")
    List<String> marketGroupNamesFromMarket();

    @Query("SELECT mg.name FROM Market m INNER JOIN MarketGroup mg ON m.marketGroup.id = mg.id WHERE mg.id = :id")
    String marketGroupNameFromMarketByMarketGroupId(@Param("id") long id);

    @Query("SELECT name FROM Market")
    List<String> getMarketNames();
}
