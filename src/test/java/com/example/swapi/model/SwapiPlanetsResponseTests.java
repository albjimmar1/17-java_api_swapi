package com.example.swapi.model;

import com.example.swapi.models.SwapiPlanetsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SwapiPlanetsResponse.class)
class SwapiPlanetsResponseTests {

	@Test
	public void swapiPeopleResponseTest() {
        SwapiPlanetsResponse swapiPlanetsResponse = new SwapiPlanetsResponse();
        SwapiPlanetsResponse swapiPlanetsResponse2 = new SwapiPlanetsResponse(0,null,null,null);
        swapiPlanetsResponse.setCount(0);
        swapiPlanetsResponse.setNext(null);
        swapiPlanetsResponse.setResults(null);
        swapiPlanetsResponse.setPrevious(null);
        Assertions.assertNull(swapiPlanetsResponse.getNext());
        Assertions.assertEquals(swapiPlanetsResponse.getCount(), 0);
        Assertions.assertNull(swapiPlanetsResponse.getResults());
        Assertions.assertNull(swapiPlanetsResponse.getPrevious());
        Assertions.assertNotNull(swapiPlanetsResponse2.toString());
    }

}
