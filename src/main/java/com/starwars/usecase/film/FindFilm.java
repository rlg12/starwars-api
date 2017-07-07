package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class FindFilm {

    private FilmRepository filmRepository;

    public FindFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film execute(@NonNull Long id){
        return filmRepository.findOne(id);
    }

}
