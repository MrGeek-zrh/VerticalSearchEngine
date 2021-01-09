package com.mrgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.component.Result;
import com.mrgeek.dao.ImportData;
/**
 * 将数据导入索引库
* <p>Title: ImportData.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2021-01-06_00:29:55
* @version 1.0
 */
@Controller
public class ImportDataController {
	
	@Autowired
	private ImportData importData;

	@RequestMapping("/import")
	@ResponseBody
	public Result importData() {
		try {
			importData.importData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Result.ok();
	}
}
