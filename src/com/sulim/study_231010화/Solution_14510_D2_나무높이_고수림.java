package study_231010화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14510_D2_나무높이_고수림 {

	static int result, max;
	static int[] arr, chaArr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = 0;
			max = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			arr = new int[N];
			chaArr = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i] = tmp;
				max = Math.max(max, tmp);
			}
			
			for(int i=0; i<N; i++) {
				chaArr[i] = max-arr[i];
			}
			
			int a = 0; // 홀수날
			int b = 0; // 짝수날
			for(int i=0; i<N; i++) {
				a += chaArr[i] % 2; // 홀수날이 몇번인지 더해주기
				b += chaArr[i] / 2; // 짝수날이 몇번인지 더해주기 (일단)
			}

			if(a < b) {
				while(Math.abs(a - b) > 1) { // 짝수 날이 더 많으니까.. 줄여줘야함
					b--;
					a += 2;
				}
			}
			
			if(a <= b) {
				result = b*2;
			} else if(a > b) {
				result = a*2 - 1;
			}
			
			System.out.println("#"+tc+" "+result);
		}

	}

}
