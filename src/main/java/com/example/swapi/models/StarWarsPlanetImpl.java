package com.example.swapi.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class StarWarsPlanetImpl implements StarWarsPlanet {

    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;
    private LocalDateTime createdLDT;

    public StarWarsPlanetImpl() {
    }

    public StarWarsPlanetImpl(String name, String rotation_period, String orbital_period, String diameter, String climate, String gravity, String terrain, String surface_water, String population, List<String> residents, List<String> films, String created, String edited, String url) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.diameter = diameter;
        this.climate = climate;
        this.gravity = gravity;
        this.terrain = terrain;
        this.surface_water = surface_water;
        this.population = population;
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
        this.createdLDT = null;
    }

    public String getName() {
        return name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public String getPopulation() {
        return population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) { this.created = created; }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getCreatedLDT() { return createdLDT; }

    public void setCreatedLDT(LocalDateTime createdLDT) {
        this.createdLDT = createdLDT;
    }

    @Override
    public String toString() {
        return "StarWarsPlanetImpl{" +
                "name='" + name + '\'' +
                ", rotation_period='" + rotation_period + '\'' +
                ", orbital_period='" + orbital_period + '\'' +
                ", diameter='" + diameter + '\'' +
                ", climate='" + climate + '\'' +
                ", gravity='" + gravity + '\'' +
                ", terrain='" + terrain + '\'' +
                ", surface_water='" + surface_water + '\'' +
                ", population='" + population + '\'' +
                ", residents=" + residents +
                ", films=" + films +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StarWarsPlanetImpl that = (StarWarsPlanetImpl) o;
        return Objects.equals(url, that.url);
    }

    public int hashCode() {
        return Objects.hash(url);
    }
}
