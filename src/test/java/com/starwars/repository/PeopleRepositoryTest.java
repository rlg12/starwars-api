package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;


/**
 * Created by rlg12 on 30/06/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PeopleRepositoryTest {

    @Autowired
    private PeopleRepository peopleRepository;

    @Test
    public void should_find_top_20_height_people() throws  Exception{
        List<People> gente = peopleRepository.findFirst20ByOrderByMassDesc();

        assertNotNull(gente);

    }



}
