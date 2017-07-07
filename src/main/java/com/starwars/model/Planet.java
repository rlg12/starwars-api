package com.starwars.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by rlg12 on 30/06/17.
 */
@Entity
@Data
//@EntityListeners({AuditingEntityListener.class})
public class Planet extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long planetId;

    private String name;
    private String diameter;
    private String rotationPeriod;
    private String orbitalPeriod;

    private String gravity;
    private String population;
    private String climate;
    private String terrain;

    private String surfaceWater;

   // private String url;
/*
    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime edited;
*/
}
