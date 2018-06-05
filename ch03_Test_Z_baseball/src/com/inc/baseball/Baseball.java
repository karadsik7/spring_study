package com.inc.baseball;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		//기능1
		int[] answers = getRandomNumbers();
		
		//테스트를 위한 코드
		for(int answer : answers) {
			System.out.print(answer);
		}
		System.out.println();
		
		
		
		while(true) {
			//기능2
			//getPredicts
			int[] predicts = getPredicts();
			
			boolean isEnd = compareArrays(answers, predicts);
			if(isEnd) {
				break;
			}
		}

	}
	
	private static int[] getPredicts() {
		Scanner scanner = new Scanner(System.in);
		int[] predicts = new int[3];
		for(int i = 0; i < predicts.length; i++) {
			System.out.println("숫자를 입력해 주세요.");
			predicts[i] = scanner.nextInt();
			for(int j = 0; j < i; j++) {
				if(predicts[i] == predicts[j]) {
					i--;
				}
			}
		}
		return predicts;
	}

	public static int[] getRandomNumbers() {
		int[] answers = new int[3];
		for(int i = 0; i < answers.length; i++) {
			answers[i] = (int)(Math.random()*10);
			for(int j = 0; j < i; j++) {
				if(answers[i] == answers[j]) {
					i--;
				}
			}
		}
		
		return answers;
	}
	
	
	public static boolean compareArrays(int[] answers, 
									    int[] predicts) {
		//기능3
		int ball = 0;
		int strike = 0;
		for(int i = 0; i < answers.length; i++) {
			for(int j = 0; j < predicts.length; j++ ) {
				if(answers[i] == predicts[j]) {
					if(i == j) {
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		if(strike == 0 && ball == 0) {
			System.out.println("3out");
		}else {
			System.out.printf("%ds, %db\n", strike, ball);
		}
		
		if(strike == 3) {
			System.out.println("축하합니다.");
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	

}
