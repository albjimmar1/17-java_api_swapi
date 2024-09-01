package com.example.swapi.service;

import com.example.swapi.builders.ResponseBuilder;
import com.example.swapi.configurations.SwapiConfig;
import com.example.swapi.models.SwapiPeopleResponse;
import com.example.swapi.models.SwapiPlanetsResponse;
import com.example.swapi.services.SwapiService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootTest(classes = SwapiService.class)
@ContextConfiguration(classes = {SwapiConfig.class})
class SwapiServiceTests {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private SwapiService swapiService;
    private static final String SEARCH_PATH = "/?search=";
    private static final String PEOPLE_PATH = "people";
    private static final String PLANETS_PATH = "planets";
    private static final String STAR_WARS_URI = "https://swapi.dev/api/";

    @Test
    public void findPeopleTest() {
        SwapiPeopleResponse response1 = new SwapiPeopleResponse(0, "next", null, new ArrayList<>());
        SwapiPeopleResponse response2 = new SwapiPeopleResponse(0, null, null, new ArrayList<>());
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PEOPLE_PATH, SwapiPeopleResponse.class))
                .thenReturn(new ResponseEntity<>(response1, HttpStatus.OK));
        Mockito.when(restTemplate.getForEntity("next", SwapiPeopleResponse.class))
                .thenReturn(new ResponseEntity<>(response2, HttpStatus.OK));
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PEOPLE_PATH + SEARCH_PATH + "byName", SwapiPeopleResponse.class))
                .thenReturn(new ResponseEntity<>(response2, HttpStatus.NO_CONTENT));
        ResponseBuilder responseWithoutParameters = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, "", null, null, null, null);
        ResponseBuilder responseSortByNameASC = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, "byName", 0, 0, "ASC", null);
        ResponseBuilder responseSortByNameDESC = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, null, 0, 0, "DESC", null);
        ResponseBuilder responseSortByCreatedASC = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, null, 0, 0, null, "ASC");
        ResponseBuilder responseSortByCreatedDESC = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, null, 0, 0, null, "DESC");
        Assertions.assertEquals(responseWithoutParameters.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseWithoutParameters.getData());
        Assertions.assertEquals(responseSortByNameASC.getStatus(), HttpStatus.NO_CONTENT);
        Assertions.assertNotNull(responseSortByNameASC.getData());
        Assertions.assertEquals(responseSortByNameDESC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByNameDESC.getData());
        Assertions.assertEquals(responseSortByCreatedASC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByCreatedASC.getData());
        Assertions.assertEquals(responseSortByCreatedDESC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByCreatedDESC.getData());
    }

    @Test
    public void findPeopleBadParametersTest() {
        ResponseBuilder responseBadParameters = swapiService.findPeople(null, null, -1, -1, "null", "null");
        Assertions.assertEquals(responseBadParameters.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNull(responseBadParameters.getData());
    }

    @Test
    public void findPeopleBadRequestTest() {
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PEOPLE_PATH, SwapiPeopleResponse.class))
                .thenThrow(new RestClientResponseException("badRequest", 400, null, null, null, null));
        ResponseBuilder responseBadParameters = swapiService.findPeople(null, null, -1, -1, "null", "null");
        Assertions.assertEquals(responseBadParameters.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNull(responseBadParameters.getData());
        ResponseBuilder responseBadRequestCaptured = swapiService.findPeople(STAR_WARS_URI + PEOPLE_PATH, null, null, null, null, null);
        Assertions.assertEquals(responseBadRequestCaptured.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNotNull(responseBadRequestCaptured.getData());
    }

    @Test
    public void findPlanetsTest() {
        SwapiPlanetsResponse response1 = new SwapiPlanetsResponse(0, "next", null, new ArrayList<>());
        SwapiPlanetsResponse response2 = new SwapiPlanetsResponse(0, null, null, new ArrayList<>());
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PLANETS_PATH, SwapiPlanetsResponse.class))
                .thenReturn(new ResponseEntity<>(response1, HttpStatus.OK));
        Mockito.when(restTemplate.getForEntity("next", SwapiPlanetsResponse.class))
                .thenReturn(new ResponseEntity<>(response2, HttpStatus.OK));
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PLANETS_PATH + SEARCH_PATH + "byName", SwapiPlanetsResponse.class))
                .thenReturn(new ResponseEntity<>(response2, HttpStatus.NO_CONTENT));
        ResponseBuilder responseWithoutParameters = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, "", null, null, null, null);
        ResponseBuilder responseSortByNameASC = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, "byName", 0, 0, "ASC", null);
        ResponseBuilder responseSortByNameDESC = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, null, 0, 0, "DESC", null);
        ResponseBuilder responseSortByCreatedASC = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, null, 0, 0, null, "ASC");
        ResponseBuilder responseSortByCreatedDESC = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, null, 0, 0, null, "DESC");
        Assertions.assertEquals(responseWithoutParameters.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseWithoutParameters.getData());
        Assertions.assertEquals(responseSortByNameASC.getStatus(), HttpStatus.NO_CONTENT);
        Assertions.assertNotNull(responseSortByNameASC.getData());
        Assertions.assertEquals(responseSortByNameDESC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByNameDESC.getData());
        Assertions.assertEquals(responseSortByCreatedASC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByCreatedASC.getData());
        Assertions.assertEquals(responseSortByCreatedDESC.getStatus(), HttpStatus.OK);
        Assertions.assertNotNull(responseSortByCreatedDESC.getData());
    }

    @Test
    public void findPlanetsBadParametersTest() {
        ResponseBuilder responseBadParameters = swapiService.findPlanets(null, null, -1, -1, "null", "null");
        Assertions.assertEquals(responseBadParameters.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNull(responseBadParameters.getData());
    }

    @Test
    public void findPlanetsBadRequestTest() {
        Mockito.when(restTemplate.getForEntity(STAR_WARS_URI + PLANETS_PATH, SwapiPlanetsResponse.class))
                .thenThrow(new RestClientResponseException("badRequest", 400, null, null, null, null));
        ResponseBuilder responseBadParameters = swapiService.findPlanets(null, null, -1, -1, "null", "null");
        Assertions.assertEquals(responseBadParameters.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNull(responseBadParameters.getData());
        ResponseBuilder responseBadRequestCaptured = swapiService.findPlanets(STAR_WARS_URI + PLANETS_PATH, null, null, null, null, null);
        Assertions.assertEquals(responseBadRequestCaptured.getStatus(), HttpStatus.BAD_REQUEST);
        Assertions.assertNotNull(responseBadRequestCaptured.getData());
    }
}
