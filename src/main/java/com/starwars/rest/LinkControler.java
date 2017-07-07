package com.starwars.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by rlg12 on 7/07/17.
 */
@Controller
@RequestMapping(path = "/links")
public class LinkControler {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResourceSupport> allLinks(){
        Link swapiLink = new Link("http://swapi.co");
        Link planetsLink = linkTo(PlanetController.class).withRel("planets");
      //  Link planetsLink = linkTo(PeopleC.class).withRel("planets");

        //linkTo((methodOn(PlanetController.class).update()))

        ResourceSupport result = new ResourceSupport();
        result.add(swapiLink);
        result.add(planetsLink);

        return new ResponseEntity<ResourceSupport>(result, HttpStatus.OK);
    }
}
