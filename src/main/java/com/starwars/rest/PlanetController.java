package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by rlg12 on 7/07/17.
 */
@RestController
//@Controller
@RequestMapping(path = "/planets")
public class PlanetController {

    private FindAllPlanets findAllPlanets;
    private SavePlanet savePlanet;
    private FindPlanet findPlanet;
    private DeletePlanet deletePlanet;


    public PlanetController(FindAllPlanets findAllPlanets, SavePlanet savePlanet, FindPlanet findPlanet, DeletePlanet deletePlanet) {
        this.findAllPlanets = findAllPlanets;
        this.savePlanet = savePlanet;
        this.findPlanet = findPlanet;
        this.deletePlanet = deletePlanet;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll(){
        List<Planet> planets = findAllPlanets.execute();
        return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save(@RequestBody Planet planet){
        Planet saved =  savePlanet.execute(planet);
        return new ResponseEntity<Planet>(saved, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Planet> get(@PathVariable Long id){
        Planet found = findPlanet.execute(id);

        return new ResponseEntity<Planet>(found, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Planet> update(@PathVariable Long id, @RequestBody Planet planet){
        Planet found = findPlanet.execute(id);
        if(found == null){
            return (ResponseEntity<Planet>) ResponseEntity.noContent();
        }
        Planet update =  savePlanet.execute(planet);
        return new ResponseEntity<Planet>(update, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Planet> delete(@PathVariable Long id){
        Planet found = findPlanet.execute(id);
        if(found == null){
            return (ResponseEntity<Planet>) ResponseEntity.notFound();
        }
        deletePlanet.execute(id);
        return (ResponseEntity<Planet>)(ResponseEntity.accepted());
    }
}
