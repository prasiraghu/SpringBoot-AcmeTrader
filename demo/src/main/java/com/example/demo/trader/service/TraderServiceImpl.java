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

		List<TraderVO> cities = jtm.query(sql, new BeanPropertyRowMapper(TraderVO.class));

		return cities;
	}

}
