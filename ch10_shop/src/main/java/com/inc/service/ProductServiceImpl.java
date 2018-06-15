package com.inc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dao.ProductDao;
import com.inc.vo.ProductVo;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductVo> list(String category) {
		return productDao.productList(category);
	}

	@Override
	public void insert(ProductVo productVo) {
		productVo.setRetail_pct(productVo.getRetail_pct() / 100);
		productDao.insert(productVo);
	}

	@Override
	public ProductVo selectOne(int id) {
		return productDao.selectOne(id);
	}
	
	
}
