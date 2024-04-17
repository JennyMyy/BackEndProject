package com.harjoitustyo.Neuletyot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.harjoitustyo.Neuletyot.web.CategoryController;
import com.harjoitustyo.Neuletyot.web.NeuletyotController;

@SpringBootTest
class NeuletyotApplicationTests {

	@Autowired
	private NeuletyotController controller;

	@Autowired
	private CategoryController cacontroller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(cacontroller).isNotNull();
	}

}
