package study;
import java.util.*;
public class Q02_11720 {

 	public static int solution(int N, String M) {
 		String[] strArr = M.split("");
 		int sum = 0;
 		
 		for(int i=0; i<N; i++) {
 			sum += Integer.parseInt(strArr[i]);
 		}
 	
 		return sum;
 	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자의 개수(N)를 입력하세요 >> ");
		int N = sc.nextInt();
		sc.nextLine();
		
		System.out.print("숫자를 입력하세요 >> ");
		String M = sc.nextLine();
		
		System.out.println("주어진 숫자 N개의 합 >> "+ solution(N,M));
	}

}
