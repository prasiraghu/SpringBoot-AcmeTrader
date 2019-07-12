package com.example.demo.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.admin.domain.AdminAccountVO;
import com.example.demo.trader.domain.TraderVO;

@Service
public class AdminAccountImpl implements AdminAccount {
	@Autowired
	private JdbcTemplate jtm;

	@Override
	public List<AdminAccountVO> saveAll(Object adminAccountVO) {
		AdminAccountVO vo = (AdminAccountVO) adminAccountVO;
		// long acctNumber = (long) Math.floor(Math.random() * 9_000_000_000L) +
		// 1_000_000_000L;
		// long traderId = (long) Math.floor(Math.random() * 4_000_0L) + 1_00_0L;
		String acctNumber = "6457675920";
		String traderId = "18217";

		vo.setAccountNumber(acctNumber);
		vo.setTraderId(traderId);
		jtm.update(
				"INSERT INTO ACCOUNT (FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER, ACCOUNTNUMBER, TRADERID)"
						+ "VALUES (?, ?, ?, ?, ?, ?)",
				vo.getFirstName(), vo.getLastName(), vo.getEmail(), vo.getPhoneNumber(), vo.getAccountNumber(),
				vo.getTraderId());
		List<AdminAccountVO> all = jtm.query("SELECT *FROM ACCOUNT", new BeanPropertyRowMapper(AdminAccountVO.class));
		return all;
	}

	@Override
	public List<AdminAccountVO> search(String acctNumber) {
		String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNTNUMBER=" + "'" + acctNumber + "'";
		List<AdminAccountVO> acctDetails = jtm.query(sql, new BeanPropertyRowMapper(AdminAccountVO.class));
		return acctDetails;
	}
}
