package com.mrgeek.service.impl;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgeek.mapper.NewsMapper;
import com.mrgeek.pojo.News;
import com.mrgeek.pojo.NewsExample;
import com.mrgeek.pojo.NewsExample.Criteria;
import com.mrgeek.service.NewsService;

/**
 * 新闻Service实现类
* <p>Title: NewsServiceImpl.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-05_22:49:48
* @version 1.0
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	
	@Override
	public List<News> findAllNews() {
		NewsExample newsExample = new NewsExample();
		List<News> list = newsMapper.selectByExample(newsExample);
		return list;
	}
	
	/**
	 * 根据id获取content
	* <p>Title: findContentByNewsId<／p>
	* <p>Description: <／p>
	* @param id
	* @return
	 */
	@Override
	public String findContentByNewsId(Integer id) {
		NewsExample newsExample = new NewsExample();
		Criteria criteria = newsExample.createCriteria();
		criteria.andIdEqualTo(id);
		List<News> list = newsMapper.selectByExampleWithBLOBs(newsExample);
		return list.get(0).getContent();
	}

}
