package com.example.swapi.model;

import com.example.swapi.models.StarWarsCharacter;
import com.example.swapi.models.StarWarsCharacterImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StarWarsCharacterImpl.class)
class StarWarsCharacterImplTests {

	@Test
	public void starWarsCharacterImplTest() {
        StarWarsCharacter starWarsCharacter1 = new StarWarsCharacterImpl();
        StarWarsCharacter starWarsCharacter2 = new StarWarsCharacterImpl(null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
        Assertions.assertNull(starWarsCharacter1.getName());
        Assertions.assertNull(starWarsCharacter1.getHeight());
        Assertions.assertNull(starWarsCharacter1.getMass());
        Assertions.assertNull(starWarsCharacter1.getHair_color());
        Assertions.assertNull(starWarsCharacter1.getSkin_color());
        Assertions.assertNull(starWarsCharacter1.getEye_color());
        Assertions.assertNull(starWarsCharacter1.getBirth_year());
        Assertions.assertNull(starWarsCharacter1.getGender());
        Assertions.assertNull(starWarsCharacter1.getHomeworld());
        Assertions.assertNull(starWarsCharacter1.getFilms());
        Assertions.assertNull(starWarsCharacter1.getSpecies());
        Assertions.assertNull(starWarsCharacter1.getVehicles());
        Assertions.assertNull(starWarsCharacter1.getStarships());
        Assertions.assertNull(starWarsCharacter1.getCreated());
        Assertions.assertNull(starWarsCharacter1.getEdited());
        Assertions.assertNull(starWarsCharacter1.getUrl());
        Assertions.assertNotNull(starWarsCharacter1.toString());
        Assertions.assertNotEquals(starWarsCharacter1.hashCode(), -1);
        assert starWarsCharacter1.equals(starWarsCharacter2);
    }

}
