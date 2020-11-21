package com.wozu.todoApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("classpath:/test.properties")
@SpringBootTest
class TodoAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
