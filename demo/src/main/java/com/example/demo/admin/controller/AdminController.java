package com.example.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.admin.domain.AdminAccountVO;
import com.example.demo.admin.service.AdminAccount;
import com.example.demo.common.JSONResponse;

@RestController
@RequestMapping(value = "/rest/admin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

	@Autowired
	private AdminAccount adminAccount;

	@RequestMapping(value = "/account/create", method = { RequestMethod.POST })
	public List<AdminAccountVO> createAcct(@RequestBody AdminAccountVO adminAccountVO) {
		return adminAccount.saveAll(adminAccountVO);
	}
}
