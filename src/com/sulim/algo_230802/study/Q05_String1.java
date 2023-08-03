package com.sulim.algo_230802.study;
import java.util.*;

public class Q05_String1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 알파벳 문자열 myString을 입력하세요 >> ");
		String myString = sc.nextLine();
		String answer = "";
		
		for(int i=0; i<myString.length(); i++) {
			if(myString.charAt(i) == 'a' || myString.charAt(i) == 'A') {
				answer += 'A';
			} else {
				answer += Character.toLowerCase(myString.charAt(i));
			}
		}
		
		System.out.println("변환 후 >> "+ answer);

	}

}
