package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class FindPlanet {

    private PlanetRepository planetRepository;


    public FindPlanet(PlanetRepository planetRepository) {

        this.planetRepository = planetRepository;
    }

    public Planet execute(@NonNull Long id){
        return planetRepository.findOne(id);
    }

}
