package com.example.demo.trader.service;

import java.util.List;

import com.example.demo.trader.domain.TraderVO;

public interface TraderService {
	public List<TraderVO> findAll();

	public List<TraderVO> findByTicker(String tickerSymbol);

	public List<TraderVO> findByMarketDt(String marketDate);

	public List<TraderVO> findByBoth(String tickerSymbol, String marketDate);

}
