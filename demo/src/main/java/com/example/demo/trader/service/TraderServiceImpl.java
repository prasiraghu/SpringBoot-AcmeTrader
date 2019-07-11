package com.example.demo.trader.service;

import java.util.List;

import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> postTickerAndMarketDt(String tickerSymbol, String marketDate, float open, float high, float low,
			float close, int volume) {
		//check for provided ticker and date.  if already in database, then will return false
		String sql = "SELECT * FROM STOCK_QUOTES WHERE STOCK_SYMBOL=" + "'" + tickerSymbol + "'" + " AND MARKET_DATE="
				+ "'" + marketDate + "'";
		List<TraderVO> resultCheck = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));
		if(!resultCheck.isEmpty()) {
			return new ResponseEntity<>("message: ticker and date provided are already present", HttpStatus.OK);
		} 
		
		int result = jtm.update("INSERT INTO STOCK_QUOTES (STOCK_SYMBOL, MARKET_DATE, OPEN, HIGH, LOW, CLOSE, VOLUME) VALUES (?, ?, ?, ?, ?, ?, ?)"
					,tickerSymbol, marketDate, open, high, low, close, volume);
		if(result == 1) {
			return new ResponseEntity<>(null, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public void deleteTickerAndMarketDt(String tickerSymbol, String marketDate) {
		// TODO Auto-generated method stub
		jtm.update("DELETE FROM STOCK_QUOTES WHERE STOCK_SYMBOL = ? AND MARKET_DATE = ?", tickerSymbol, marketDate);
	}
	
	
	
}
