package com.mrgeek.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mrgeek.component.News;
import com.mrgeek.dao.ImportData;
import com.mrgeek.utils.FileUtil;
import com.mrgeek.utils.HttpClientUtil;
import com.mrgeek.utils.JsonUtil;

/**
 * 将数据导入索引库中
* <p>Title: ImportDataImpl.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-06_00:05:48
* @version 1.0
 */
@Component
public class ImportDataImpl implements ImportData{

	@Autowired
	private SolrServer solrServer;
	
	@Value("${DATA_URL}")
	private String DATA_URL;
	
	@Override
	public void importData() throws Exception {
		// TODO Auto-generated method stub
		String doGet = HttpClientUtil.doGet(DATA_URL);
		List<News> list = JsonUtil.jsonToList(doGet, News.class);
		for (News news : list) {
			//创建document对象
			SolrInputDocument document = new SolrInputDocument();
			//添加域
			document.addField("news_title", news.getTitle());
			document.addField("news_image", news.getImage());
			document.addField("news_id", news.getId());
			try {
				solrServer.add(document);
				solrServer.commit();
			} catch (SolrServerException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
