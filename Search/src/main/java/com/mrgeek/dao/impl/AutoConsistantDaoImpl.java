package com.mrgeek.dao.impl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mrgeek.dao.AutoConsistantDao;
import com.mrgeek.utils.HttpClientUtil;

/**
 * 实现智能提示框
* <p>Title: AutoConsistantDaoImpl.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-05_21:15:20
* @version 1.0
 */
@Component
public class AutoConsistantDaoImpl implements AutoConsistantDao {
	
	@Value("${AUTO_CONSISTANT_URL}")
	private String AUTO_CONSISTANT_URL;

	@Override
	public String getTerms(String term) throws ParseException, IOException {
		
		HashMap<String, String> param = new HashMap<>();
		param.put("wt", "json");
		param.put("terms.fl", "news_title");
		param.put("indent", "true");
		param.put("terms.prefix", term);
		String doGet = HttpClientUtil.doGet(AUTO_CONSISTANT_URL, param);
		return doGet;
	}

}
