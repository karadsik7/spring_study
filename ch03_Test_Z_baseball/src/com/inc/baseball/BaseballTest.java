package com.inc.baseball;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class BaseballTest {
	
	Baseball baseball;
	
	@Before
	public void setUp() {
		baseball = new Baseball();
	}
	
	@Test
	public void getPredicts() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Baseball.class.getDeclaredMethod("getPredicts");
		method.setAccessible(true);
		int[] predicts = (int[])method.invoke(Baseball.class);
		assertSame(3, predicts.length);
		assertSame(10, predicts[0]);
		assertSame(20, predicts[1]);
		assertSame(30, predicts[2]);
	}
	
	//getRandomNumbers(), compareArrays() 테스트
	
	@Test
	public void getRandomNumbers() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Baseball.class.getDeclaredMethod("getRandomNumbers");
		method.setAccessible(true);
		int[] answers = (int[])method.invoke("getRandomNumbers");
		assertSame(3, answers.length);
		for(int i = 0; i < 10000; i++) {
			assertNotEquals(answers[0], answers[1]);
			assertNotEquals(answers[1], answers[2]);
			assertNotEquals(answers[0], answers[2]);
		}
	}
	
	
	@Test
	public void compareArrays() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = Baseball.class.getDeclaredMethod("compareArrays", int[].class, int[].class);
		int[] answers = {1, 5, 9};
		int[] predicts = {1, 2, 3};
		boolean result = (boolean)method.invoke(Baseball.class, answers, predicts);
		assertFalse(result);
		
		int[] predicts2 = {1, 5, 9};
		boolean result2 = (boolean)method.invoke(Baseball.class, answers, predicts2);
		assertTrue(result2);
		
	}
	
	
}
