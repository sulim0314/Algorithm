package com.sulim.algo_230802.study;
import java.util.*;

public class Q04_UpperLower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 알파벳 문자열 str을 입력하세요 >> ");
		String str = sc.nextLine();
		String answer = "";
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i))) {
				answer += Character.toUpperCase(str.charAt(i));
			} else {
				answer += Character.toLowerCase(str.charAt(i));
			}
		}
		
		System.out.println("변환 후 >> "+ answer);
	}

}
