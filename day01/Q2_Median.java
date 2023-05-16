package day01;
import java.util.*;
public class Q2_Median {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("3개의 정수를 입력하세요 >> ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = median(a, b, c);
		
		System.out.println(result);
		
	}

	public static int median(int a, int b, int c) {
		int med = -1;

        if (a >= b) {
            if (b >= c) {
                med = b;
            } else if (c >= a) {
                med = a;
            } else {
                med = c;
            }
        } else if (a >= c) {
            med = a;
        } else if (b >= c) {
            med = c;
        } else {
            med = b;
        }

        return med;
	}

	/*
	private static int median(int a, int b, int c) {
	    int arr[] = {a, b, c};
	    for (int j = 0; j < 3; j++) {
	        for (int i = 0; i < 2; i++) {
	            if (arr[i] < arr[i + 1]) {
	                int m = arr[i];
	                arr[i] = arr[i + 1];
	                arr[i + 1] = m;
	            }
	        }
	    }
	    return arr[1];
	} */
	
	
}
