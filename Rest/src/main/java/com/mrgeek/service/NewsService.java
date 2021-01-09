package com.mrgeek.service;

import java.util.List;

import com.mrgeek.pojo.News;

/**
 * 新闻service
* <p>Title: NewsService.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-05_22:11:57
* @version 1.0
 */
public interface NewsService {
	public List<News> findAllNews();

	/**
	 * 根据id获取content
	* <p>Title: findContentByNewsId<／p>
	* <p>Description: <／p>
	* @param id
	* @return
	 */
	String findContentByNewsId(Integer id);
}
