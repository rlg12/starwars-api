package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.usecase.film.FindAllFilm;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by rlg12 on 7/07/17.
 */
@Controller
@RequestMapping(path = "/films")
@AllArgsConstructor
public class FilmController {

    private FindAllFilm findAllFilm;
    private EntityLinks entityLinks;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Film>> findAll(){
        List<Film> peliculas = findAllFilm.execute();

        peliculas.forEach((Film peli) -> {
            peli.getPlanets().forEach((Planet planet ) ->{
                Link selftLink = linkTo(methodOn(PlanetController.class).get(planet.getPlanetId())).withSelfRel();
                if(planet.getLinks().isEmpty()) {
                    planet.add(selftLink);
                }
            });


        });

        return new ResponseEntity<List<Film>>(peliculas, HttpStatus.OK);
    }
}
