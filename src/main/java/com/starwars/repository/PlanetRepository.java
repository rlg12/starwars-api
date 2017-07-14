package com.starwars.repository;

import com.starwars.model.Planet;
import com.starwars.model.PlanetOnlyNameAndPopulation;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by rlg12 on 30/06/17.
 */
@RepositoryRestResource(excerptProjection = PlanetOnlyNameAndPopulation.class)
public interface PlanetRepository extends JpaRepository<Planet,Long> {
    Planet findByName(String name);
    //Page<Planet> findAll(Pageable pageable);
    List<Planet> findByNameContaining(String name);
    List<Planet> findAllByOrderByNameDesc();
    List<Planet> findByPopulationBetween(Long min, Long max);
    List<Planet> findTop10ByOrderByPopulationDesc();
    List<Planet> findTop10ByOrderByPopulationAsc();
    List<Planet> findByPopulationIsGreaterThanEqual(Long population);

}
