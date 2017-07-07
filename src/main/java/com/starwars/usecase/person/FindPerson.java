package com.starwars.usecase.person;

import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class FindPerson {

    private PeopleRepository peopleRepository;


    public FindPerson(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public People execute(@NonNull Long id){
        return peopleRepository.findOne(id);
    }

}
