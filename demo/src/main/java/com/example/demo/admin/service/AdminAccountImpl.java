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
		jtm.execute("INSERT INTO ACCOUNT (FIRSTNAME, LASTNAME, EMAIL, PHONENUMBER, ACCOUNTNUMBER, TRADERID)"
				+ "VALUES (" + "'" + vo.getFirstName() + "'" + ","
				+ "'Maldonado', 'alex.maldonado22@yahoo.com', '2147935760','123456789','12345')");
		List<AdminAccountVO> all = jtm.query("SELECT *FROM ACCOUNT", new BeanPropertyRowMapper(AdminAccountVO.class));
		return all;
	}
}
