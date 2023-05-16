package day01;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q6_ArrayCopy {
	
	public static int[] inputArray(int nth) {
		Scanner sc = new Scanner(System.in);
		System.out.println("배열 "+nth+"의 요소수 입력: ");
		int num1 = sc.nextInt();
		// 배열 생성
		int[] arr = new int[num1];
		// 반복문 돌면서 배열에 값 저장하기
		for (int i = 0; i < num1; i++) {
			System.out.print("arr["+i+"] : ");
			arr[i] = sc.nextInt();
		}
		return arr;
	} //------------------------------
	
	// 카피
	public static void copy(int[] a,int[] b) { 
		
		if(a.length < b.length) {
			b = a;
			System.out.println("배열 a를 b로 카피 완료");
			for(int copyarr:b) {
				System.out.print(copyarr+",");
			}
			System.out.println();
		} else {
			a = b;
			System.out.println("배열 b를 a로 카피 완료");
			for(int copyarr:a) {
				System.out.print(copyarr+",");
			}
			System.out.println();
		}
	} //-------------------------------
	
	// 역순 카피
	public static void reverse_copy(int[] a, int[] b) { 
		
		int num = (a.length < b.length) ? a.length: b.length;
		
		for(int i=0; i<num; i++) {
			if(a.length < b.length) {
				b[i] = a[num-1 -i];
			} else {
				a[i] = b[num-1 -i];
			}
		}// for--
		
		System.out.println("역순으로 카피 완료");
	} //------------------------------
	
	// swap ★
	public static int[] reverse(int[] a) {
		for(int i=0; i<a.length/2; i++) {
			int tmp = a[i];
			a[i] = a[a.length-1 -i];
			a[a.length-1 -i] = tmp;
		}
		return a;
	} //------------------------------
	
	
	public static void main(String[] args) {
		int[] a = inputArray(1);
		int[] b = inputArray(2);
		
		// copy(a,b);
		// reverse_copy(a,b);
		
		System.out.println("배열 a: " + Arrays.toString(a));
		System.out.println("배열 b: " + Arrays.toString(b));
		
		int[] b2 = reverse(b);
		System.out.println("배열 b: " + Arrays.toString(b));

	}
}