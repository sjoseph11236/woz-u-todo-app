package com.wozu.todoApp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
class TodoAppApplicationTests {

	@BeforeAll
	static void setUp(){
	}

	@Test
	void contextLoads() {
	}

}
