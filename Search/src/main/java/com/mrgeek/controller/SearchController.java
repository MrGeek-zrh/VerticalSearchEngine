package com.mrgeek.controller;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.component.News;
import com.mrgeek.service.SearchService;

@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/search")
	@ResponseBody
	public List<News> search(@RequestParam String queryString) {
		List<News> list = null;
		try {
			list = searchService.searchResult(queryString);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
