package com.example.swapi.services;

import com.example.swapi.builders.ResponseBuilder;
import com.example.swapi.models.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SwapiService {

    @Autowired
    private RestTemplate restTemplate;
    final Logger log = LoggerFactory.getLogger(SwapiService.class);
    private static final String SEARCH_PATH = "/?search=";
    private static final String GETPEOPLE_ERROR_MESSAGE = "SWAPI service getPeople: ";
    private static final String GETPLANETS_ERROR_MESSAGE = "SWAPI service getPlanets: ";
    private static final List<String> ORDERS = Arrays.asList("ASC", "DESC");
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    public ResponseBuilder findPeople(String url, String byName, Integer limit, Integer offset, String sortByName, String sortByCreated) {
        boolean badLimit = limit != null && limit < 0;
        boolean badOffset = offset != null && offset < 0;
        boolean badSortByName = sortByName != null && !ORDERS.contains(sortByName.toUpperCase());
        boolean badSortByCreated = sortByCreated != null && !ORDERS.contains(sortByCreated.toUpperCase());
        if (badLimit || badOffset || badSortByName || badSortByCreated) {
            log.error(GETPEOPLE_ERROR_MESSAGE + "limit or offset conflict.");
            return new ResponseBuilder(null, HttpStatus.BAD_REQUEST);
        }
        List<StarWarsCharacterImpl> results = new ArrayList<>();
        HttpStatus responseStatus = null;
        if (byName != null && !byName.isEmpty())
            url += SEARCH_PATH + byName;
        try {
            boolean again = true;
            while (again) {
                ResponseEntity<SwapiPeopleResponse> response = restTemplate.getForEntity(url, SwapiPeopleResponse.class);
                if (response.getStatusCode().equals(HttpStatus.OK)) {
                    results.addAll(Objects.requireNonNull(response.getBody()).getResults());
                    if (response.getBody().getNext() != null) {
                        url = response.getBody().getNext();
                    } else {
                        again = false;
                    }
                } else {
                    again = false;
                }
                responseStatus = (HttpStatus) response.getStatusCode();
            }
        } catch (RestClientResponseException e) {
            responseStatus = (HttpStatus) e.getStatusCode();
            log.error(GETPEOPLE_ERROR_MESSAGE + e.getMessage());
        }
        List<StarWarsCharacterImpl> finalResults = results.stream()
                .skip(offset == null ? 0 : offset)
                .limit(limit == null ? results.size() : limit)
                .collect(Collectors.toList());
        if (ASC.equals(sortByName)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsCharacter::getName).reversed()).collect(Collectors.toList());
        } else if (DESC.equals(sortByName)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsCharacter::getName)).collect(Collectors.toList());
        } else if (ASC.equals(sortByCreated)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsCharacter::getCreated)).collect(Collectors.toList());
        } else if (DESC.equals(sortByCreated)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsCharacter::getCreated).reversed()).collect(Collectors.toList());
        }
        return new ResponseBuilder(finalResults, responseStatus);
    }

    public ResponseBuilder findPlanets(String url, String byName, Integer limit, Integer offset, String sortByName, String sortByCreated) {
        boolean badLimit = limit != null && limit < 0;
        boolean badOffset = offset != null && offset < 0;
        boolean badSortByName = sortByName != null && !ORDERS.contains(sortByName);
        boolean badSortByCreated = sortByCreated != null && !ORDERS.contains(sortByCreated);
        if (badLimit || badOffset || badSortByName || badSortByCreated) {
            log.error(GETPLANETS_ERROR_MESSAGE + "limit or offset conflict.");
            return new ResponseBuilder(null, HttpStatus.BAD_REQUEST);
        }
        List<StarWarsPlanetImpl> results = new ArrayList<>();
        HttpStatus responseStatus = null;
        if (byName != null && !byName.isEmpty())
            url += SEARCH_PATH + byName;
        try {
            boolean again = true;
            while (again) {
                ResponseEntity<SwapiPlanetsResponse> response = restTemplate.getForEntity(url, SwapiPlanetsResponse.class);
                if (response.getStatusCode().equals(HttpStatus.OK)) {
                    results.addAll(Objects.requireNonNull(response.getBody()).getResults());
                    if (response.getBody().getNext() != null) {
                        url = response.getBody().getNext();
                    } else {
                        again = false;
                    }
                } else {
                    again = false;
                }
                responseStatus = (HttpStatus) response.getStatusCode();
            }
        } catch (RestClientResponseException e) {
            responseStatus = (HttpStatus) e.getStatusCode();
            log.error(GETPLANETS_ERROR_MESSAGE + e.getMessage());
        }
        List<StarWarsPlanetImpl> finalResults = results.stream()
                .skip(offset == null ? 0 : offset)
                .limit(limit == null ? results.size() : limit)
                .collect(Collectors.toList());
        if (ASC.equals(sortByName)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsPlanet::getName).reversed()).collect(Collectors.toList());
        } else if (DESC.equals(sortByName)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsPlanet::getName)).collect(Collectors.toList());
        } else if (ASC.equals(sortByCreated)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsPlanet::getCreated)).collect(Collectors.toList());
        } else if (DESC.equals(sortByCreated)) {
            finalResults = finalResults.stream().sorted(Comparator.comparing(StarWarsPlanet::getCreated).reversed()).collect(Collectors.toList());
        }
        return new ResponseBuilder(finalResults, responseStatus);
    }

}
