package com.example.demo.trader.service;

import java.util.List;

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
}
