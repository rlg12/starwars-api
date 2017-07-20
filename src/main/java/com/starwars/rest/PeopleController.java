package com.starwars.rest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rlg12 on 7/07/17.
 */
@RestController
@RequestMapping(path = "/peoples")
@AllArgsConstructor
public class PeopleController {
}
