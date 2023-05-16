package day01;

import java.util.Scanner;

public class Q9_UpperLower {
	
	public String solution(String str) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<str.length(); i++) {
			if(Character.isLowerCase(str.charAt(i))) {
				sb.append(Character.toUpperCase(str.charAt(i)));
			} else {
				sb.append(Character.toLowerCase(str.charAt(i)));
			}
		}
		answer = sb.toString();
		return answer;
	}
	
	public String solution2(String str) {
		String answer = "";
		
		char[] ch = str.toCharArray();
		StringBuffer buf = new StringBuffer();
		for(char c: ch) {
			if(Character.isUpperCase(c)) {
				buf.append(Character.toLowerCase(c));
			} else {
				buf.append(Character.toUpperCase(c));
			}
		}
		
		answer = buf.toString();
		return answer;
	}
	
	public static String solution3(String str) {
		String answer="";
		
		int diff='a'-'A';
		for(int i=0; i<str.length(); i++) {
			answer+=(str.charAt(i)>='a')? (char)(str.charAt(i)-diff):(char)(str.charAt(i)+diff);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Q9_UpperLower app = new Q9_UpperLower(); // static이 아닐 때 ★
		System.out.println("알파벳 문자열을 입력하세요");
		String str = sc.nextLine();
		
		System.out.println(app.solution(str));
	}

}
