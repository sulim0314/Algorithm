package study;
import java.util.*;

public class Q03_StringMix {

	public static String solution(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str1.length(); i++) {
        	sb.append(str1.charAt(i));
        	sb.append(str2.charAt(i));
        }
       
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 문자열 str1을 입력해주세요 >> ");
		String str1 = sc.nextLine();
		System.out.print("두번째 문자열 str2을 입력해주세요 >> ");
		String str2 = sc.nextLine();

		System.out.println(">> "+ solution(str1, str2));
	}

}
