package study;
import java.util.*;

public class Q10_SumArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열 1의 개수 >> ");
		int n = sc.nextInt();
		System.out.print("배열 2의 개수 >> ");
		int m = sc.nextInt();
		int[] arr = new int[n + m];
		
		System.out.print("배열 1에 저장할 값을 오름차순으로 입력 >> ");
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("배열 2에 저장할 값을 오름차순으로 입력 >> ");
		for(int i=n; i<n+m; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}
