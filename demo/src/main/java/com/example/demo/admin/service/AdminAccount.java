package com.example.demo.admin.service;

import java.util.List;

import com.example.demo.admin.domain.AdminAccountVO;

public interface AdminAccount {

	public List<AdminAccountVO> saveAll(Object adminAccountVO);

	public List<AdminAccountVO> search(String acctNumber);
}
