package com.inc.service;

import java.util.List;

import com.inc.vo.ProductVo;

public interface ProductService {

	List<ProductVo> list(String category);

	void insert(ProductVo productVo);
	
	ProductVo selectOne(int id);
	
}
