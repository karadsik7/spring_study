package com.inc.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.vo.CartVo;

@Repository
public class CartDao {
	
	@Autowired
	private SqlSession session;
	
	public List<CartVo> cartList(String u_id){
		List<CartVo> cartList = session.selectList("cart.selectList", u_id);
		return cartList;
	}

	public int getCount(Map<String, Object> idMap) {
		int count = session.selectOne("cart.getCount", idMap);
		return count;
	}
	
	public void insert(Map<String, Object> idMap) {
		session.insert("cart.insert", idMap);
	}

	public void modify(CartVo cvo) {
		session.update("cart.modify", cvo);
	}

	public void delete(int id) {
		session.delete("cart.delete", id);
	}
	
}
