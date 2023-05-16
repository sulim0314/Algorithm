package study;
import java.util.*;

public class Q06_String2 {

	public static String solution(String my_string, int s, int e) {
        String answer = "";
        
        for(int i=0; i<s; i++) {
        	answer += my_string.charAt(i);
        }
  
        for(int i=0; i<=e-s; i++) {
        	answer += my_string.charAt(e-i);
        }
        
        for(int i=e+1; i<my_string.length(); i++) {
        	answer += my_string.charAt(i);
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 알파벳 문자열 my_string을 입력하세요 >> ");
		String my_string = sc.nextLine();
		
		System.out.print("시작 인덱스 s를 입력해주세요 >> ");
		int s = sc.nextInt();
		System.out.print("끝 인덱스 e를 입력해주세요 >> ");
		int e = sc.nextInt();
		sc.nextLine();
		
		System.out.println("result >> "+ solution(my_string, s, e));
	}

}
