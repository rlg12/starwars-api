package com.starwars.repository;


import com.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static javax.management.Query.and;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by rlg12 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {

    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_by_name() throws  Exception{
        Planet planet = planetRepository.findByName("Alderaan");

        assertThat(planet.getName(),is("Alderaan"));

    }

    @Test
    public void should_find_by_all_paginable() {

        Sort ordenable= new Sort(Sort.Direction.DESC,"terrain").and(new Sort(Sort.Direction.DESC,"gravity"));
        PageRequest param = new PageRequest(0,2,ordenable);
        Page<Planet> planetas = planetRepository.findAll(param);

        planetas.getContent().stream().forEach(System.out::println);

    }


}
