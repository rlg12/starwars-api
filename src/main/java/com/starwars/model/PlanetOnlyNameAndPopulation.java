package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by rlg12 on 14/07/17.
 */
@Projection(name = "planetOnlyNameAndPopulation", types = Planet.class)
public interface PlanetOnlyNameAndPopulation {
    String getName();
    Long getPopulation();
}
