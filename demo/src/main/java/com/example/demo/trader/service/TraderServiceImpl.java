package com.example.demo.trader.service;

import java.util.List;

import org.apache.logging.log4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.trader.domain.TraderVO;

@Service
public class TraderServiceImpl implements TraderService {
	@Autowired
	private JdbcTemplate jtm;

	@Override
	public List<TraderVO> findAll() {
		String sql = "SELECT * FROM STOCK_QUOTES";
		List<TraderVO> all = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		return all;
	}

	@Override
	public List<TraderVO> findByTicker(String tickerSymbol) {
		String sql = "SELECT * FROM STOCK_QUOTES WHERE STOCK_SYMBOL=" + "'" + tickerSymbol + "'";
		List<TraderVO> ticker = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		return ticker;
	}

	@Override
	public List<TraderVO> findByMarketDt(String marketDate) {
		String sql = "SELECT * FROM STOCK_QUOTES WHERE MARKET_DATE=" + "'" + marketDate + "'";
		List<TraderVO> date = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		return date;
	}

	@Override
	public List<TraderVO> findByBoth(String tickerSymbol, String marketDate) {
		String sql = "SELECT * FROM STOCK_QUOTES WHERE STOCK_SYMBOL=" + "'" + tickerSymbol + "'" + " AND MARKET_DATE="
				+ "'" + marketDate + "'";
		List<TraderVO> both = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		return both;
	}

	@Override
	public boolean postTickerAndMarketDt(String tickerSymbol, String marketDate, float open, float high, float low,
			float close, int volume) {
		//TODO - check that there is no entry for given tickerSymbol and marketDate
//		String sql = "SELECT * FROM STOCK_QUOTES WHERE STOCK_SYMBOL = " + tickerSymbol + " AND MARKET_DATE = " + marketDate + "\";";
//		String sql = "SELECT * FROM STOCK_QUOTES;";
//		System.out.println(jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		int result = jtm.update("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) VALUES (?, ?, ?, ?, ?, ?, ?)"
					,tickerSymbol, marketDate, open, high, low, close, volume);
		return result==1;
	}

	@Override
	public void deleteTickerAndMarketDt(String tickerSymbol, String marketDate) {
		// TODO Auto-generated method stub
		jtm.update("DELETE FROM STOCK_QUOTES WHERE STOCK_SYMBOL = ? AND MARKET_DATE = ?", tickerSymbol, marketDate);
	}
	
	
	
}
