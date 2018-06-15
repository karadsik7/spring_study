package com.inc.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.vo.ProductVo;

@Repository
public class ProductDao {

	@Autowired
	private SqlSession session; 
	
	public List<ProductVo> remainList(){
		return session.selectList("products.remainList");
	}
	
	public List<ProductVo> inList(){
		return session.selectList("products.inList");
	}
	
	public List<ProductVo> outList(){
		return session.selectList("products.outList");
	}

	public void addIn(ProductVo productVo) {
		session.insert("products.addIn", productVo);
	}

	public ProductVo getByName(String name) {
		return session.selectOne("products.getByName", name);
	}

	public void addRemain(ProductVo productVo) {
		session.insert("products.addRemain", productVo);
	}

	public void setCount(ProductVo productVo) {
		session.update("products.setCount", productVo);
	}

	public void addOut(ProductVo productVo) {
		session.insert("products.addOut", productVo);
	}
	
	
	
}
