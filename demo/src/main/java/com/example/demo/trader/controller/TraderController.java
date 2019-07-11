package com.example.demo.trader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.trader.domain.TraderVO;
import com.example.demo.trader.service.TraderService;

@RestController
public class TraderController {

	@Autowired
	private TraderService traderService;

	@RequestMapping("/trader/stockquotes")
	public List<TraderVO> findTicker(@RequestParam (required = false) String ticker, @RequestParam (required = false) String date) {
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
}
