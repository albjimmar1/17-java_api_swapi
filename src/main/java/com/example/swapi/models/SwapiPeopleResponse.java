package com.example.swapi.models;

import java.util.List;

public class SwapiPeopleResponse {

     private int count;
     private String next;
     private String previous;
     private List<StarWarsCharacterImpl> results;

    public SwapiPeopleResponse() {
    }

    public SwapiPeopleResponse(int count, String next, String previous, List<StarWarsCharacterImpl> results) {
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

    public List<StarWarsCharacterImpl> getResults() {
        return results;
    }

    public void setResults(List<StarWarsCharacterImpl> results) {
        this.results = results;
    }

    public String toString() {
        return "SwapiPeopleResponse{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
