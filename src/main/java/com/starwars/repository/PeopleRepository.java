package com.starwars.repository;

import com.starwars.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by rlg12 on 30/06/17.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {
    People findByNameIgnoreCase(String name);
    List<People> findByHeightIsGreaterThanEqual(String height);
    List<People> findByEyeColorIn(Collection<String> eyeColor);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameDesc(Collection<String> eyeColor);

    @Query(value = "select p from People p where name like 'S%'")
    List<People> findByNameStartedWith();

}
