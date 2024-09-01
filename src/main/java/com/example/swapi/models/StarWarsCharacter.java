package com.example.swapi.models;

import java.time.LocalDateTime;
import java.util.List;

public interface StarWarsCharacter {
    String getName();
    String getHeight();
    String getMass();
    String getHair_color();
    String getSkin_color();
    String getEye_color();
    String getBirth_year();
    String getGender();
    String getHomeworld();
    List<String> getFilms();
    List<String> getSpecies();
    List<String> getVehicles();
    List<String> getStarships();
    LocalDateTime getCreated();
    LocalDateTime getEdited();
    String getUrl();
}
