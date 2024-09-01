package com.example.swapi.models;

import java.util.List;

public class SwapiPlanetsResponse {

     private int count;
     private String next;
     private String previous;
     private List<StarWarsPlanetImpl> results;

    public SwapiPlanetsResponse() {
    }

    public SwapiPlanetsResponse(int count, String next, String previous, List<StarWarsPlanetImpl> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<StarWarsPlanetImpl> getResults() {
        return results;
    }

    public void setResults(List<StarWarsPlanetImpl> results) {
        this.results = results;
    }

    public String toString() {
        return "SwapiPlanetsResponse{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
