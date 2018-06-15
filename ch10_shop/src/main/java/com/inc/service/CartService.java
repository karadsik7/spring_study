package com.inc.service;

import java.util.List;
import java.util.Map;

import com.inc.vo.CartVo;

public interface CartService {

	List<CartVo> cartList(String u_id);

	int getTotal(String u_id);

	void del(int id);

	String insert(Map<String, Object> idMap);

	void modify(CartVo cvo);
	

}
