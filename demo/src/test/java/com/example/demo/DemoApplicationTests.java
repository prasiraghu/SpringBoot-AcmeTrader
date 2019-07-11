package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.*;

import io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class DemoApplicationTests {

	@Test
	public void EndpointTest() {
		when().get("/trader/stockquotes").then().statusCode(200);
	}

	@Test
	public void TraderAbleToViewStockQuotes() {
		when().get("/trader/stockquotes").then().assertThat().body("stock_symbol", notNullValue());
	}

	@Test
	public void TraderAddStockSuccessfully() {
		when().post("/trader/stockquotes").then().statusCode(201);
	}

	@Test
	public void TraderDeleteStockSuccessfully() {
		when().delete("/trader/stockquotes").then().statusCode(200);
	}

}
