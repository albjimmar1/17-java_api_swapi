package com.example.swapi.model;

import com.example.swapi.models.StarWarsPlanet;
import com.example.swapi.models.StarWarsPlanetImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StarWarsPlanetImpl.class)
class StarWarsPlanetImplTests {

	@Test
	public void starWarsPlanetImplTest() {
        StarWarsPlanet starWarsPlanet1 = new StarWarsPlanetImpl();
        StarWarsPlanet starWarsPlanet2 = new StarWarsPlanetImpl(null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        Assertions.assertNull(starWarsPlanet1.getName());
        Assertions.assertNull(starWarsPlanet1.getRotation_period());
        Assertions.assertNull(starWarsPlanet1.getOrbital_period());
        Assertions.assertNull(starWarsPlanet1.getDiameter());
        Assertions.assertNull(starWarsPlanet1.getClimate());
        Assertions.assertNull(starWarsPlanet1.getGravity());
        Assertions.assertNull(starWarsPlanet1.getTerrain());
        Assertions.assertNull(starWarsPlanet1.getSurface_water());
        Assertions.assertNull(starWarsPlanet1.getPopulation());
        Assertions.assertNull(starWarsPlanet1.getResidents());
        Assertions.assertNull(starWarsPlanet1.getFilms());
        Assertions.assertNull(starWarsPlanet1.getCreated());
        Assertions.assertNull(starWarsPlanet1.getEdited());
        Assertions.assertNull(starWarsPlanet1.getUrl());
        Assertions.assertNotNull(starWarsPlanet1.toString());
        Assertions.assertNotEquals(starWarsPlanet1.hashCode(), -1);
        assert starWarsPlanet1.equals(starWarsPlanet2);
    }

}
