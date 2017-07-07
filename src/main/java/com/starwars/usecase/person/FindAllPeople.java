package com.starwars.usecase.person;

import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class FindAllPeople {

    private PeopleRepository peopleRepository;


    public FindAllPeople(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }


    public List<People> execute(){
        return peopleRepository.findAll();
    }

}
