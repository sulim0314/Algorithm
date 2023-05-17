package study;
import java.util.*;

public class Q13_Ssireum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("씨름선수 후보 인원 수 ▼ ");
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		
		System.out.println("키, 몸무게 순으로 입력 ▼ ");
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// ★ int[][] arr = new int[n][2] 를 내림차순으로
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(b[0], a[0]);
            }
        });
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[n-1-i][0] +" "+ arr[n-1-i][1]);
		}
		
		int cnt = n;
		for(int i=n-1; i>=0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(arr[j][1] > arr[i][1]) {
					arr[i][1] = 0;
					cnt--;
					break;
				}
			}
		}
		
		System.out.println(cnt +"명 선발 가능");
		System.out.println("--- 선발된 씨름 선수 ---");
		for(int i=0; i<n; i++) {
			if(arr[i][1] != 0) {
				System.out.println(arr[i][0] +" "+ arr[i][1]);
			}
		}
	}

}
