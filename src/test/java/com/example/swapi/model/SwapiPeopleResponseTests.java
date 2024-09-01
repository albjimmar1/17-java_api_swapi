package com.example.swapi.model;

import com.example.swapi.models.SwapiPeopleResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SwapiPeopleResponse.class)
class SwapiPeopleResponseTests {

	@Test
	public void swapiPeopleResponseTest() {
        SwapiPeopleResponse swapiPeopleResponse = new SwapiPeopleResponse();
        SwapiPeopleResponse swapiPeopleResponse2 = new SwapiPeopleResponse(0,null,null,null);
        swapiPeopleResponse.setCount(0);
        swapiPeopleResponse.setNext(null);
        swapiPeopleResponse.setResults(null);
        swapiPeopleResponse.setPrevious(null);
        Assertions.assertNull(swapiPeopleResponse.getNext());
        Assertions.assertEquals(swapiPeopleResponse.getCount(), 0);
        Assertions.assertNull(swapiPeopleResponse.getResults());
        Assertions.assertNull(swapiPeopleResponse.getPrevious());
        Assertions.assertNotNull(swapiPeopleResponse2.toString());
    }

}
