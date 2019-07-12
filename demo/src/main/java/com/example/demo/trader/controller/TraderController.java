package com.example.demo.trader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.admin.domain.AdminAccountVO;
import com.example.demo.admin.service.AdminAccount;
import com.example.demo.trader.domain.TraderVO;
import com.example.demo.trader.service.TraderService;

@RestController
@RequestMapping(value = "/rest/trader", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class TraderController {

	@Autowired
	private TraderService traderService;

	@Autowired
	private AdminAccount adminAccount;

	@RequestMapping("/findstockquotes")
	public List<TraderVO> findTicker(@RequestParam(required = false) String ticker,
			@RequestParam(required = false) String date) {
		String tickerSymbol = ticker;
		String marketDate = date;

		if (tickerSymbol != null & marketDate != null) {
			return traderService.findByBoth(tickerSymbol, marketDate);
		} else if (tickerSymbol != null) {
			return traderService.findByTicker(tickerSymbol);
		} else if (marketDate != null) {
			return traderService.findByMarketDt(marketDate);
		} else {
			return traderService.findAll();
		}
	}

	@PostMapping("/addstockquotes")
	public ResponseEntity<?> submitTickerAndMarketDate(@RequestBody TraderVO traderVO) {
		String ticker = traderVO.getStock_symbol().toUpperCase();
		String marketDate = traderVO.getMarket_date();
		float open = traderVO.getOpen();
		float high = traderVO.getHigh();
		float low = traderVO.getLow();
		float close = traderVO.getClose();
		int volume = traderVO.getVolume();
		return traderService.postTickerAndMarketDt(ticker, marketDate, open, high, low, close, volume);
	}

	// update existing method based on ticker and date - required
	// will only update based on which open/high/low/close/volume is provided?
	// Put-Patch Request

	@DeleteMapping("/removestockquotes")
	public ResponseEntity<?> deleteTickerAndMarketDate(@RequestBody TraderVO traderVO) {
		return traderService.deleteTickerAndMarketDt(traderVO.getStock_symbol().toUpperCase(),
				traderVO.getMarket_date());
	}

	@RequestMapping(value = "/account", method = { RequestMethod.GET })
	public List<AdminAccountVO> searchAcct(@RequestParam(required = false) String acctNumber,
			@RequestParam(required = false) String Name) {
		return adminAccount.search(acctNumber);
	}

}
