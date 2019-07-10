package com.example.demo.trader.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.trader.domain.TraderVO;
import com.example.demo.trader.service.TraderService;

@RestController
public class Controller {
	
	@Autowired
	private TraderService traderService;

    @RequestMapping("/trader/stockquotes")
    public List<TraderVO> findTicker(){
    	return traderService.findAll();
    }
}