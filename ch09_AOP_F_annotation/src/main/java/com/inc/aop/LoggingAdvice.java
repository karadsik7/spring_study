package com.inc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	public void before(JoinPoint jp) {
		Signature s = jp.getSignature();
		logger.info("--before : " + s);
	}
	
	public void after(JoinPoint jp) {
		Signature s = jp.getSignature();
		logger.info("--after : " + s);
	}
	
}
