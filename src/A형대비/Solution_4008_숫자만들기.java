package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author sulim
 *	max = -Integer.MAX_VALUE; 이렇게 안하고 -1 이라고 했다가 1시간 삽질한듯
 *
 */
public class Solution_4008_숫자만들기 {

	static int N, result, min, max;
	static int[] numArr;
	static int[] data, num;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int t = Integer.parseInt(st.nextToken());

		for(int tc=1; tc<=t; tc++) {
			result = 0;
			max = -Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			data = new int[4];
			num = new int[N-1];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			numArr = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				numArr[i] = Integer.parseInt(st.nextToken());
			}
			
			per(0);
			result = max - min;
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void per(int cnt) {
		
		if(cnt == N-1) {
			// 순열 완성
			cal();
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(data[i] > 0) {
				data[i]--;
				num[cnt] = i;
				per(cnt+1);
				data[i]++;
			}
		}
		
	}

	private static void cal() {
		int r = numArr[0];
		for(int i=0; i<N-1; i++) {
			if(num[i] == 0) {
				r += numArr[i+1]; 
			} else if(num[i] == 1) {
				r -= numArr[i+1];
			} else if(num[i] == 2) {
				r *= numArr[i+1];
			} else if(num[i] == 3) {
				r /= numArr[i+1];
			}
		}
		
		min = Math.min(min, r);
		max = Math.max(max, r);
		
	}

}
