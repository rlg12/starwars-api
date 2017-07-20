package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleWithNoPersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by rlg12 on 30/06/17.
 */
@RepositoryRestResource(path = "persons", excerptProjection = PeopleWithNoPersonalInfo.class)
public interface PeopleRepository extends JpaRepository<People,Long> {
    @RestResource(path = "name", rel = "name")
    People findByNameIgnoreCase(String name);
    List<People> findByHeightIsGreaterThanEqual(String height);
    List<People> findByEyeColorIn(Collection<String> eyeColor);
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameDesc(Collection<String> eyeColor);

    @Query(value = "select p from People p where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartedWith();

}
