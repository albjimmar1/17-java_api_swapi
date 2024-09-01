package com.example.swapi.controllers;

import com.example.swapi.builders.ResponseBuilder;
import com.example.swapi.services.SwapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swapi/v1")
public class SwapiController {

    @Autowired
    SwapiService swapiService;
    private static final String PEOPLE_PATH = "people";
    private static final String PLANETS_PATH = "planets";
    private static final String STAR_WARS_URI = "https://swapi.dev/api/";

    @GetMapping(path = {"/people/", "/people"})
    public ResponseEntity<Object> getPeople(@RequestParam(required = false) String byName, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) String sortByName, @RequestParam(required = false) String sortByCreated) {
        ResponseBuilder response = this.swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, byName, limit, offset, sortByName, sortByCreated);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @GetMapping(path = {"/planets/", "/planets"})
    public ResponseEntity<Object> getPlanets(@RequestParam(required = false) String byName, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer offset, @RequestParam(required = false) String sortByName, @RequestParam(required = false) String sortByCreated) {
        ResponseBuilder response = this.swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, byName, limit, offset, sortByName, sortByCreated);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
