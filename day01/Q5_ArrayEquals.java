package day01;
import java.util.*;

public class Q5_ArrayEquals {
	
	public static int[] inputArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열의 요소 수 입력 : ");
		int num1=sc.nextInt();
		//배열 생성
		int [] arr = new int[num1];
		//반복문 돌면서 배열에 값 저장하기 
		for(int i=0; i<num1; i++) {
			System.out.println("arr["+i+"] : ");
			int input = sc.nextInt();
			arr[i] = input;
		}
		return arr;
		
	}
	
	public static boolean solution(int[] a, int b[]) {
		boolean bool = false;
		for(int i=0;i<a.length; i++) {
			if(a[i]==b[i]) {
				bool=true;
			} else {
				bool=false;
				break;
			}
		}
		return bool;
	}
	
	public static void main(String[] args) {
		boolean res = solution(inputArray(), inputArray());
		if(res) 
			System.out.println("배열 a와 b는 같습니다.");
		else 
			System.out.println("배열 a와 b는 같지 않습니다.");
		
	}
	
}