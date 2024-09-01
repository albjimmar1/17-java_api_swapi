package com.example.swapi.controller;

import com.example.swapi.builders.ResponseBuilder;
import com.example.swapi.controllers.SwapiController;
import com.example.swapi.services.SwapiService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SwapiController.class)
class SwapiControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SwapiService swapiService;
    private static final String PEOPLE_PATH = "people";
    private static final String PLANETS_PATH = "planets";
    private static final String STAR_WARS_URI = "https://swapi.dev/api/";

    @Test
    public void findPeopleTest() throws Exception {
        Mockito.when(swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH,null,null,null,null,null))
                .thenReturn(new ResponseBuilder(null, HttpStatus.OK));
        mockMvc.perform(get("/swapi/v1/people/").content("null")).andExpect(status().isOk());
    }

    @Test
    public void findPlanetsTest() throws Exception {
        Mockito.when(swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH,null,null,null,null,null))
                .thenReturn(new ResponseBuilder(null, HttpStatus.OK));
        mockMvc.perform(get("/swapi/v1/planets/").content("null")).andExpect(status().isOk());
    }


}
