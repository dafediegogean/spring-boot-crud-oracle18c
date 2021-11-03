package com.poc.sboracl18cxe;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application.properties")
public class MarcaIT {
	
	@LocalServerPort
	private int port;
	
	private static final int MARCA_ID_EXISTENTE = 1;
	
	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
	}
	
	@Test
	public void retornaStatus200_QuandoConsultarMarcas() {
		RestAssured
			.given()
				.basePath("/v1/marcas")
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void retornaStatus200_QuandoConsultaMarcaExistente() {
		RestAssured
			.given()
				.pathParam("marcaId", MARCA_ID_EXISTENTE)
				.accept(ContentType.JSON)
			.when()
				.get("/v1/{marcaId}/marcas")
			.then()
				.statusCode(HttpStatus.OK.value())
				.body("nome", Matchers.equalTo("Toyota"));
	}
	
}
