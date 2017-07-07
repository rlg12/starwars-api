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
public class SavePeople {

    private PeopleRepository peopleRepository;


    public SavePeople(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public People execute(@NonNull People person){
        return peopleRepository.save(person);
    }
}
