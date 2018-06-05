package practice;

import java.util.Scanner;

public class Calculator {
	
	//코드 리팩토링 연습
		//1. 기능을 분류하고
		//2. 중복된 코드를 별도의 메서드로 관리
		
	
	public void add() {
		int[] numbers = getNumbers();
		int result = numbers[0] + numbers[1];
		print("덧셈", result);
	}
	
	public void minus() {
		int[] numbers = getNumbers();
		int result = numbers[0] - numbers[1];
		print("뺄셈", result);
	}
	
	private int[] getNumbers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("첫 번째 숫자를 입력해주세요.");
		int first = scanner.nextInt();
		System.out.println("두 번째 숫자를 입력해주세요.");
		int second = scanner.nextInt();
		int[] first_second = {first, second};
		return first_second;
	}
	
	private void print(String msg, int result) {
		System.out.println(msg + " 결과 : " + result);
	}
}
