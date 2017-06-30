package com.starwars.repository;

import com.starwars.model.Film;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by rlg12 on 30/06/17.
 */
@Slf4j
public class FilmRepositoryImpl implements CustomFilmRepository {
    private static Logger LOGGER = LoggerFactory.getLogger(FilmRepositoryImpl.class);

    @Override
    public void logFim(Film film) {
        LOGGER.info(film.toString());
    }

}
