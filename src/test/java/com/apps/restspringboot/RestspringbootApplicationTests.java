package com.apps.restspringboot;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestspringbootApplicationTests {

	@Autowired
	HelloController controller;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testHello() {

		assertTrue(controller.getHello().equalsIgnoreCase("hi"));
	}
}
