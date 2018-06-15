package com.inc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.vo.ProductVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSession session;
	
	public List<ProductVo> productList(String category){
		List<ProductVo> productList = session.selectList("product.productList", category);
		return productList;
	}

	public ProductVo selectOne(int id) {
		ProductVo pvo = session.selectOne("product.getProductVo", id);
		return pvo;
	}

	public void insert(ProductVo pvo) {
		session.insert("product.insert", pvo);
	}
	
	
	
}
