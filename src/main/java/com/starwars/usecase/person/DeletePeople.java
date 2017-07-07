package com.starwars.usecase.person;

import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import lombok.NonNull;
import org.springframework.stereotype.Service;

/**
 * Created by rlg12 on 7/07/17.
 */
@Service
public class DeletePeople {

    private PeopleRepository peopleRepository;


    public DeletePeople(PeopleRepository peopleRepository) {

        this.peopleRepository = peopleRepository;
    }

    public void execute(@NonNull Long id){
        peopleRepository.delete(id);
    }

}
