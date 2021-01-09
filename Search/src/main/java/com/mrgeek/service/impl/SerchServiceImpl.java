package com.mrgeek.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgeek.component.News;
import com.mrgeek.component.Result;
import com.mrgeek.dao.SearchDao;
import com.mrgeek.service.SearchService;

/**
 * 搜索功能实现
* <p>Title: SerchService.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-13_20:53:08
* @version 1.0
 */
@Service
public class SerchServiceImpl implements SearchService{
	
	@Autowired
	private SearchDao searchDao;

	public List<News> searchResult(String queryString) throws SolrServerException {
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置默认搜索域	
		query.set("df", "news_title");
		List<News> list = searchDao.search(query);
		return list;
	}

}
