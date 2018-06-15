package com.inc.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.inc.vo.ProductVo;

@Component
public class ProductServiceTx implements ProductService{

	@Autowired
	@Qualifier(value="productServiceImpl")
	ProductService productService;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@Override
	public Map<String, List<ProductVo>> productMap() {
		//트랜잭션 쓸 필요가 없으므로 바로 리턴
		return productService.productMap();
	}

	@Override
	public void addIn(ProductVo productVo) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			productService.addIn(productVo);
			transactionManager.commit(status);
		} catch (RuntimeException e) {
			transactionManager.rollback(status);
			throw e;
		}
	}

	@Override
	public void addOut(ProductVo productVo) {
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		try {
			productService.addOut(productVo);
			transactionManager.commit(status);
		} catch (RuntimeException e) {
			transactionManager.rollback(status);
			throw e;
		}
	}
	
}
