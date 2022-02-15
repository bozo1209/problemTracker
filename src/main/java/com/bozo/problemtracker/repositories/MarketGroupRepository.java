package com.bozo.problemtracker.repositories;

import com.bozo.problemtracker.entities.MarketGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketGroupRepository extends JpaRepository<MarketGroup, Long> {

    @Query("SELECT mg.name FROM MarketGroup mg WHERE mg.id = :id")
    String findNameById(@Param("id") long id);
}
