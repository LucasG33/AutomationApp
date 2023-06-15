package com.cg;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.pageobjects.LoginPage;

@SpringBootTest
class AutomationAppApplicationTests {

	@Autowired
	LoginPage loginpage;

	@BeforeEach
	private void open() throws InterruptedException {
		loginpage.openPage();
	}

	@Test
	void emailTest() throws InterruptedException {
		loginpage.navigate();
		loginpage.fillForm("nombrePrueba", "correoprueba@gmail,com", "prueba", "prueba");
		loginpage.sendForm();
		assertEquals("La dirección e-mail parece inválida.", loginpage.getAlert());
	}

	@AfterEach
	private void exit() throws InterruptedException {
		loginpage.quitDriver();
	}

}
