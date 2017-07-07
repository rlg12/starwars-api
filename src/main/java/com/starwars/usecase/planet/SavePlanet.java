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
public class SavePlanet {

    private PlanetRepository planetRepository;


    public SavePlanet(PlanetRepository planetRepository) {

        this.planetRepository = planetRepository;
    }

    public Planet execute(@NonNull Planet planet){
        return planetRepository.save(planet);
    }
}
