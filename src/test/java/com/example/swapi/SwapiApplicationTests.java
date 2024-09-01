package com.example.swapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SwapiApplication.class)
class SwapiApplicationTests {

	@Test
	public void mainTest() {
        SwapiApplication.main(new String[0]);
    }

}
