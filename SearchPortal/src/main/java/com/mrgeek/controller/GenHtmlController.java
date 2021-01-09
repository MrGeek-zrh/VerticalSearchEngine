package com.mrgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.service.StaticHtmlService;

/**
 * 生成html
* <p>Title: GenHtmlController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-07_01:25:10
* @version 1.0
 */
@Controller
public class GenHtmlController {

	@Autowired
	private StaticHtmlService staticHtmlService;
	
	@RequestMapping("/gen/html/{id}")
	@ResponseBody
	public String genHtml(@PathVariable String id) {
		staticHtmlService.generatorHtml(id);
		return "ok";
	}
}
