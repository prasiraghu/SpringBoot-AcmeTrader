package com.example.demo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static io.restassured.RestAssured.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;


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
		when().post("/trader/stockquotes").then().statusCode(200);
	}

	@Test
	public void TraderDeleteStockSuccessfully() {
		when().delete("/trader/stockquotes").then().statusCode(200);
	}
	
	

}
