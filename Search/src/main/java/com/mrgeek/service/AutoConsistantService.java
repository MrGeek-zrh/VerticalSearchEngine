package com.mrgeek.service;

import java.util.List;

/**
 * 智能下拉框
* <p>Title: AutoConsistantService.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-20_18:38:36
* @version 1.0
 */
public interface AutoConsistantService {

	public List<String> getTerms(String term) throws Exception;
}
