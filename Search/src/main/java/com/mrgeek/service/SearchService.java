package com.mrgeek.service;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.mrgeek.component.News;
import com.mrgeek.component.Result;

public interface SearchService {
	
	public List<News> searchResult(String keyword) throws SolrServerException;
}
