package com.example.demo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;

import java.awt.PageAttributes.MediaType;

import org.apache.http.client.methods.RequestBuilder;

import static io.restassured.RestAssured.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.trader.controller.TraderController;
import com.example.demo.trader.domain.TraderVO;
import com.example.demo.trader.service.TraderService;
import com.example.demo.trader.service.TraderServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

//	@Test
//	public void EndpointTest() {
//		when().get("/trader/stockquotes").then().statusCode(200);
//	}
//
//	@Test
//	public void TraderAbleToViewStockQuotes() {
//		when().get("/trader/stockquotes").then().assertThat().body("stock_symbol", notNullValue());
//	}
//
//	@Test
//	public void TraderAddStockSuccessfully() {
//		when().post("/trader/stockquotes").then().statusCode(200);
//	}
//
//	@Test
//	public void TraderDeleteStockSuccessfully() {
//		when().delete("/trader/stockquotes").then().statusCode(200);
//	}
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void submitTickerAndMarketDateTest() throws Exception {
		
		String bodyJSONString = "{\r\n" + 
				"	\"stock_symbol\":\"test\", \r\n" + 
				"	\"market_date\":\"2019-07-11\",\r\n" + 
				"	\"open\":103.03,\r\n" + 
				"	\"high\":105.05,\r\n" + 
				"	\"low\":100.01,\r\n" + 
				"	\"close\":104.04,\r\n" + 
				"	\"volume\":2357654\r\n" + 
				"}";
				
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/rest/trader/addstockquotes")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(bodyJSONString)
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		//confirm that successful entry is CREATED
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	

}
