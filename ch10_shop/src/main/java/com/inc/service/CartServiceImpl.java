package com.inc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dao.CartDao;
import com.inc.vo.CartVo;

@Service("cartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	@Override
	public List<CartVo> cartList(String u_id) {
		return cartDao.cartList(u_id);
	}

	@Override
	public int getTotal(String u_id) {
		List<CartVo> cartList = cartList(u_id);
		int total = 0;
		for (CartVo cvo : cartList) {
			double price = cvo.getCount() * (1 - cvo.getPvo().getRetail_pct()) * cvo.getPvo().getPrice();
			price = Math.round(price);
			total += price;
		}
		return total;
	}

	@Override
	public void del(int id) {
		cartDao.delete(id);
	}

	@Override
	public String insert(Map<String, Object> idMap) {
		int count = cartDao.getCount(idMap);
		if (count == 0) {
			// 존재하지 않을 시 cart테이블에 추가
			cartDao.insert(idMap);
			return "y";
		} else {
			// 추가x 메세지 출력
			return "n";
		}
	}

	@Override
	public void modify(CartVo cvo) {
		cartDao.modify(cvo);
	}
	
	
	
	

}
