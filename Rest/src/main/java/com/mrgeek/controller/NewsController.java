package com.mrgeek.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.pojo.News;
import com.mrgeek.service.NewsService;

/**
 * news controller
* <p>Title: NewsController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-05_23:03:27
* @version 1.0
 */
@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@RequestMapping("/allnews")
	@ResponseBody
	public List<News> findAllNews() {
		return newsService.findAllNews();
	}
	
	@RequestMapping(value = "/content/{id}",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String findContentByNewsId(@PathVariable String id) {
		String content = null;
		content = newsService.findContentByNewsId(Integer.parseInt(id));
		return content;
	}
}
