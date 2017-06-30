package com.starwars.repository;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;


/**
 * Created by rlg12 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void should_find_by_max_people() throws  Exception{
        List<Film> peliculas = filmRepository.findAllByMaxPeople();
        assertNotNull(peliculas);
    }

    @Test
    public void should_print_all_films() {
        List<Film> peliculas = filmRepository.findAll();
        peliculas.stream().forEach(System.out::println);

    }

}
