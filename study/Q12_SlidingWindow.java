package study;
import java.util.*;
public class Q12_SlidingWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇일의 매출기록을 입력하실겁니까?");
		int n = sc.nextInt(); // 10
		
		System.out.println("연속 며칠의 매출을 구할까요?");
		int k = sc.nextInt(); // 3
		
		int[] sales = new int[n];
		System.out.println(n +"일간의 매출기록을 입력하세요");
		for(int i=0; i<n; i++) {
			sales[i] = sc.nextInt(); // 18 22 15 25 19 26 12 17 27 21
		}
		
        int maxSales = getMaxSales(sales, k);
        System.out.println("연속된 "+ k +"일간의 최대 매출액: "+ maxSales);
    }

    public static int getMaxSales(int[] sales, int k) {
        int maxSales = 0;
        int windowSum = 0;

        // 초기 윈도우 합 계산 // 55
        for (int i = 0; i < k; i++) {
            windowSum += sales[i];
        }

        // 첫 번째 윈도우 합을 최대 매출액으로 설정
        maxSales = windowSum;

        // sliding window 방식으로 최대 매출액 갱신
        for (int i = k; i < sales.length; i++) {
            windowSum += sales[i] - sales[i - k]; // 새로운 요소 추가 및 이전 요소 제거
            maxSales = Math.max(maxSales, windowSum); // 큰 값 선택
        }

        return maxSales;
    }

}
