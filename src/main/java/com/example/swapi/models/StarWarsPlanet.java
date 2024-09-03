package com.example.swapi.models;

import java.time.LocalDateTime;
import java.util.List;

public interface StarWarsPlanet {
    String getName();
    String getRotation_period();
    String getOrbital_period();
    String getDiameter();
    String getClimate();
    String getGravity();
    String getTerrain();
    String getSurface_water();
    String getPopulation();
    List<String> getResidents();
    List<String> getFilms();
    String getCreated();
    String getEdited();
    String getUrl();
    LocalDateTime getCreatedLDT();
}
