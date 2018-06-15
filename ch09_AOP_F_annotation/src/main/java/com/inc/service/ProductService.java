package com.inc.service;

import java.util.List;
import java.util.Map;

import com.inc.vo.ProductVo;

public interface ProductService {
	
	public Map<String, List<ProductVo>> productMap();
	
	public void addIn(ProductVo productVo);
	
	public void addOut(ProductVo productVo);
	
	
	
}
