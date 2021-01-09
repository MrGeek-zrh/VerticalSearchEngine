package com.mrgeek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrgeek.component.News;
import com.mrgeek.dao.SearchDao;
@Component
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;
	
	@Override
	public List<News> search(SolrQuery query) throws SolrServerException {
		//执行查询
		QueryResponse response = solrServer.query(query);
		//取查询结果列表
		List<News>list = new ArrayList<>();
		SolrDocumentList solrDocumentList = response.getResults();
		for (SolrDocument solrDocument : solrDocumentList) {
			//创建一个SearchResult对象
			News news = new News();
			news.setId(Integer.parseInt((String) solrDocument.get("news_id")));
			news.setImage((String) solrDocument.get("news_image"));
			news.setTitle((String)solrDocument.get("news_title"));
			//添加到列表
			list.add(news);
		}
		return list;
	}

	
}
