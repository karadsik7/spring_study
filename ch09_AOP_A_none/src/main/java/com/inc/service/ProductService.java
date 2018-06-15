package com.inc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dao.ProductDao;
import com.inc.exception.ProductException;
import com.inc.vo.ProductVo;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Map<String, List<ProductVo>> productMap(){
		Map<String, List<ProductVo>> productMap = new HashMap<>();
		//남은 재고
		productMap.put("remainList", productDao.remainList());
		//입고
		productMap.put("inList", productDao.inList());
		//출고
		productMap.put("outList", productDao.outList());
		
		return productMap;
	}

	public void addIn(ProductVo productVo) {
		productDao.addIn(productVo);
		ProductVo remainVo = productDao.getByName(productVo.getName());
		if(remainVo == null) {
			//재고테이블에도 튜플 추가
			productDao.addRemain(productVo);
		}else {
			//재고테이블에 해당 상품 재고만 증가
			productDao.setCount(productVo);
		}
	}

	public void addOut(ProductVo productVo) throws ProductException {
		ProductVo remainVo = productDao.getByName(productVo.getName());
		if(remainVo == null) {
			throw new ProductException("존재하지 않는 상품입니다.");
		}else if(productVo.getCount() > remainVo.getCount()) {
			throw new ProductException("상품 갯수가 충분하지 않습니다.");
		}else{
			productDao.addOut(productVo);
			//음수화
			productVo.setCount(productVo.getCount() * -1);
			//메서드 재사용
			productDao.setCount(productVo);
		}
		
	}
	
	
	
	
	
}
