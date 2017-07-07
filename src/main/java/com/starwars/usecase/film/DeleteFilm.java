package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class DeleteFilm {

    private FilmRepository filmRepository;

    public DeleteFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void execute(@NonNull Long id){
        filmRepository.delete(id);
    }

}
