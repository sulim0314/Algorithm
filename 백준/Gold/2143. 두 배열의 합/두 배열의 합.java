import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static long T, result;
	static int n, m;
	static int[] arr1, arr2;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// data 입력받기
		T = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr1 = new int[n];
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr2 = new int[m];
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		// 누적합 배열로 만들기
		for(int i=1; i<n; i++) {
			arr1[i] += arr1[i-1];
		}
		for(int i=1; i<m; i++) {
			arr2[i] += arr2[i-1];
		}
		
		int aSize = n * (n+1) / 2;
		long[] aSum = new long[aSize];
		int idx = 0;
		// 첫번째 배열에서 가능한 모든경우의 합
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int x = arr1[j];
				if(i>0) {
					x -= arr1[i-1];
				}
				aSum[idx++] = x;
			}
		}
		// ex :
		// 1 2 3 4 
		// 1 3 6 10 
		// 1 3 6 10 2 5 9 3 7 4 
		
		int bSize = m * (m+1) / 2;
		long[] bSum = new long[bSize];
		idx = 0;
		// 2번째 배열에서 가능한 모든경우의 합
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				int x = arr2[j];
				if(i > 0) x -= arr2[i-1];
				bSum[idx++] = x;
			}
		}
		
		Arrays.sort(aSum);
		Arrays.sort(bSum);
		
		int start = 0; // arr1 처음부터 시작
		int end = bSize - 1; // arr2 끝부터 시작
		
		while(start < aSize && end > -1) {
			long a = aSum[start];
			long b = bSum[end];
			long sum = a + b;
			
			if(sum == T) {
				long aCnt = 0;
				long bCnt = 0;
				
				// 같은값 세주기
				while(start < aSize && a == aSum[start]) {
					start++;
					aCnt++;
				}
				while(end > -1 && b == bSum[end]) {
					end--;
					bCnt++;
				}
				result += aCnt * bCnt;
				
			} else if(sum > T) {
				end--;
			} else if(sum < T) {
				start++;
			}
			
		}
		
		System.out.println(result);
		
	}
}
