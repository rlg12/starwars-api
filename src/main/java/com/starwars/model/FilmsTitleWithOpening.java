package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by Rafa on 20/07/2017.
 */
@Projection(name = "filmsTitleWithOpening", types = Film.class)
public interface FilmsTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();
//    List<PeopleWithNoPersonalInfo> getPeople();
}