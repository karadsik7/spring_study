package com.inc.main;

import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자1:");
		int first = scanner.nextInt();
		System.out.println("숫자2:");
		int second = scanner.nextInt();
		System.out.println(first+second);
		scanner.close();
	}
}
