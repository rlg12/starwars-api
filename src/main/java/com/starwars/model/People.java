package com.starwars.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rlg12 on 30/06/17.
 */
@Entity
@Data
public class People {
    @Id
    @GeneratedValue
    private Long peopleId;

    private String name;
    private String birthYear;
    private String eyeColor;
    private String gender;
    private String hairColor;
    private String height;
    private String mass;
    private String skinColor;

}
