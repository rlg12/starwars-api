package com.starwars.repository;

import com.starwars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rlg12 on 30/06/17.
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {
    Planet findByName(String name);
    List<Planet> findByNameContaining(String name);
    List<Planet> findAllByOrderByNameDesc();
    List<Planet> findByPopulationBetween(Long min, Long max);
    List<Planet> findTop10ByOrderByPopulationDesc();
    List<Planet> findTop10ByOrderByPopulationAsc();
    List<Planet> findByPopulationIsGreaterThanEqual(Long population);

}
