package day01;

import java.util.Scanner;

public class Q10_LongWord {

	public String solution(String str) {
		String answer = "";
		
		String[] strArr = str.split(" ");
		int max = strArr[0].length();
		
		for(int i=1; i<strArr.length; i++) {
			if(strArr[i].length() > max) {
				max = strArr[i].length();
				answer = strArr[i];
			}
		}
			
		return answer;
	}
	
	//int indexOf("검색문자열") : 검색한 문자열의 인덱스 번호를 반환한다. 검색한 문자열이 없다면 -1을 반환한다
	//String substring(int start, int end): start인덱스에서 시작해서 end-1까지 오려내서 반환
	//String substring(int start): start에서 끝까지 오려내서 반환
	
	public static void main(String[] args) {
		System.out.print("문자열을 입력하세요 >> ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Q10_LongWord q10 = new Q10_LongWord();
		System.out.println("가장 긴 단어 : " + q10.solution(str));
		
	}
}
