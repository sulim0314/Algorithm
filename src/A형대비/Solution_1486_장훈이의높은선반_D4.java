package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486_장훈이의높은선반_D4 {

	static int result, min;
	static int N, B;
	static int[] people;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for(int tc=1; tc<=t; tc++) {
			result = 0;
			min = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			people = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				people[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			result = min - B;
			System.out.println("#"+tc+" "+result);
		}
		
	}

	private static void dfs(int idx, int sum) {

		if(sum >= B) {
			min = Math.min(min, sum);
			return;
		}
		
		if(idx >= N) {
			return;
		}
		
		dfs(idx+1, sum);
		dfs(idx+1, sum+=people[idx]);
		
	}

}
