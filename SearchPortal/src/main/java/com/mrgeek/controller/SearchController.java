package com.mrgeek.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mrgeek.service.SearchService;
import com.mrgeek.service.StaticHtmlService;
import com.mrgeek.utils.HttpClientUtil;
import com.mrgeek.utils.JsonUtil;
import com.mrgeek.utils.News;
import com.mrgeek.utils.NewsSon;

/**
 * 查询服务
* <p>Title: SearchController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_20:47:45
* @version 1.0
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Value("${STATIC_PAGE_PATH}")
	private String STATIC_PAGE_PATH;
	
	@Value("${NGINX_HTML_URL}")
	private String NGINX_HTML_URL;
	
	@Autowired
	private StaticHtmlService staticHtmlService;
	
	@RequestMapping(value = "/search",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public String search(@RequestParam String wd,HttpServletRequest request) {
		String result = null;
		List<String>list1 = new ArrayList<>();
		try {
			result = searchService.search(wd);
			File file = new File(STATIC_PAGE_PATH);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File file2 : files) {
					String index = file2.getName().substring(0, file2.getName().indexOf("."));
					list1.add(index);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<News> list = JsonUtil.jsonToList(result, News.class);
		List<NewsSon>list2 = new ArrayList<>();
		for (News news : list) {
			NewsSon newsSon = new NewsSon();
			newsSon.setImage(news.getImage());
			newsSon.setTitle(news.getTitle());
			if (list1.contains(news.getId().toString())) {
				newsSon.setUrl(NGINX_HTML_URL+news.getId()+".html");
			}else {
				try {
					staticHtmlService.generatorHtml(news.getId().toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list2.add(newsSon);
		}
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("newslist", list2);
		return "content";
	}
	
}
