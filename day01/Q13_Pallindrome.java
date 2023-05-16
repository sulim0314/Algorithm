package day01;

import java.util.*;

public class Q13_Pallindrome {

	public static String solution(String str) {
		String answer = "Pallindrom Ok~";
		String strL = str.toLowerCase();
		
		for(int i=0; i<strL.length()/2; i++) {
			if(strL.charAt(i) != strL.charAt(strL.length()-1-i)) {
				answer = "Pallindrom No!";
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 => ");
		String str = sc.next();
		
		System.out.println("회문 문자열이 맞아요? " + solution(str));
		
	}

}
