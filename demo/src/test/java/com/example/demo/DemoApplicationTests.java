package com.example.demo;

import static org.hamcrest.CoreMatchers.notNullValue;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.admin.controller.AdminController;
import com.example.demo.admin.domain.AdminAccountVO;
import com.example.demo.trader.controller.TraderController;
import com.example.demo.trader.domain.TraderVO;
import com.example.demo.trader.service.TraderService;
import com.example.demo.utils.TestUtil;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private TraderController traderController;
	@Autowired
	private AdminController adminController;
	@Autowired
	private MockMvc mockMvc;
//	@Test
//	public void EndpointTest1() {
//		when().get("/trader/stockquotes").then().statusCode(200);
//	}
//
//	@Test
//	public void TraderAbleToViewStockQuotes() {
//		when().get("/trader/stockquotes").then().assertThat().body("stock_symbol", notNullValue());
//	}

	@Test
	public void StockQuoteHasAllMinimalInfo() {
		// init
		TraderVO stockQuote1 = new TraderVO();

		// condition
		stockQuote1.setStock_symbol("AAPL");
		stockQuote1.setMarket_date("2018-01-24");
		stockQuote1.setOpen((float) 160.36);
		stockQuote1.setHigh((float) 160.63);
		stockQuote1.setLow((float) 158.4);
		stockQuote1.setVolume(20340900);

		// validation
		assertNotNull(stockQuote1);
	}

	@Test
	public void AddStockQuote() throws Exception {
		// init
		TraderVO stockQuote2 = new TraderVO();
		stockQuote2.setStock_symbol("TEST1");
		stockQuote2.setMarket_date("2018-01-23");
		stockQuote2.setOpen((float) 170.36);
		stockQuote2.setHigh((float) 170.63);
		stockQuote2.setLow((float) 168.4);
		stockQuote2.setVolume(20340900);

		// condition
		ResponseEntity<TraderVO> responseEntity = (ResponseEntity<TraderVO>) traderController
				.submitTickerAndMarketDate(stockQuote2);

		// validation
		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
		System.out.println(HttpStatus.CREATED.value());
		System.out.println(responseEntity.getStatusCodeValue());
	}

	@Test
	public void DeleteStockQuote() throws Exception {
		// init
		TraderVO stockQuote2 = new TraderVO();
		stockQuote2.setStock_symbol("TEST1");
		stockQuote2.setMarket_date("2018-01-23");
		stockQuote2.setOpen((float) 170.36);
		stockQuote2.setHigh((float) 170.63);
		stockQuote2.setLow((float) 168.4);
		stockQuote2.setVolume(20340900);

		// condition
		ResponseEntity<TraderVO> responseEntity1 = (ResponseEntity<TraderVO>) traderController
				.submitTickerAndMarketDate(stockQuote2);
		// init
		TraderVO stockQuote3 = new TraderVO();
		stockQuote3.setStock_symbol("TEST1");
		stockQuote3.setMarket_date("2018-01-23");

		// condition
		ResponseEntity<TraderVO> responseEntity2 = (ResponseEntity<TraderVO>) traderController
				.deleteTickerAndMarketDate(stockQuote3);

		// validation
		assertEquals(HttpStatus.OK.value(), responseEntity2.getStatusCodeValue());
		System.out.println(HttpStatus.OK.value());
		System.out.println(responseEntity2.getStatusCodeValue());
	}
	
	@Test
	public void DeleteStockQuoteThatDoesNotExist() throws Exception {
		// init
		TraderVO stockQuote3 = new TraderVO();
		stockQuote3.setStock_symbol("TEST");
		stockQuote3.setMarket_date("2018-01-23");

		// condition
		ResponseEntity<TraderVO> responseEntity = (ResponseEntity<TraderVO>) traderController
				.deleteTickerAndMarketDate(stockQuote3);

		// validation
		assertEquals(HttpStatus.NOT_FOUND.value(), responseEntity.getStatusCodeValue());
		System.out.println(HttpStatus.NOT_FOUND.value());
		System.out.println(responseEntity.getStatusCodeValue());
	}
//	@Test
//	public void CreateAccount() throws Exception {
//		// init
//		AdminAccountVO account = new AdminAccountVO();
//		account.setFirstName("John");
//		account.setLastName("Doe");
//		account.setEmail("abc@abc.com");
//		account.setPhoneNumber("5555555555");
////		account.setAccountNumber("AAA000001");
////		account.setTraderId("");
//
//		// condition
//		ResponseEntity<AdminAccountVO> responseEntity = (ResponseEntity<AdminAccountVO>) adminController
//				.createAcct(account);
//
//		// validation
//		assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
//		System.out.println(responseEntity.getStatusCodeValue());
//	}
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
