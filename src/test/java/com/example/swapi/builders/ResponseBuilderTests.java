package com.example.swapi.builders;

import com.example.swapi.builders.ResponseBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ResponseBuilder.class)
class ResponseBuilderTests {

	@Test
	public void responseBuilderTest() {
        ResponseBuilder response1 = new ResponseBuilder();
        ResponseBuilder response2 = new ResponseBuilder(new Object(), null);
        ResponseBuilder response3 = new ResponseBuilder(null);
        response1.setData(null);
        response1.setStatus(null);
        Assertions.assertNull(response1.getData());
        Assertions.assertNull(response1.getStatus());
        Assertions.assertNotNull(response2.getData());
        Assertions.assertNull(response2.getStatus());
        Assertions.assertNull(response3.getData());
        Assertions.assertNull(response3.getStatus());
    }

}
