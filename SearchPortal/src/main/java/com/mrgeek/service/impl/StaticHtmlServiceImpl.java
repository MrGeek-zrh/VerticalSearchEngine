package com.mrgeek.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.mrgeek.service.StaticHtmlService;
import com.mrgeek.utils.HttpClientUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Service
public class StaticHtmlServiceImpl implements StaticHtmlService {

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Value("${CONTENT_URL}")
	private String CONTENT_URL;
	
	@Value("${STATIC_PAGE_PATH}")
	private String STATIC_PAGE_PATH;
	
	@Override
	public void generatorHtml(String id) {
		// TODO Auto-generated method stub
		String content;
		try {
			content = HttpClientUtil.doGet(CONTENT_URL+"/"+id);
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate("content.ftl");
			Map root = new HashMap<>();
			//向数据集中添加属性
			root.put("content", content);
			//创建一个Writer对象
			Writer out = new FileWriter(new File(STATIC_PAGE_PATH + id + ".html"));
			//生成静态文件
			template.process(root, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
