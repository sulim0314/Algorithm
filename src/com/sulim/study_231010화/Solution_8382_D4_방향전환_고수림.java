package study_231010화;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8382_D4_방향전환_고수림 {

	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			cal((Math.abs(x1-x2)),(Math.abs(y1-y2)));
			
			System.out.println("#"+tc+" "+result);
		}
		
		
	}

	private static void cal(int a, int b) {

		if(Math.abs(a-b) == 0 || Math.abs(a-b) == 1) {
			result = a+b;
		} else if((a%2==0 && b%2==0) || (a%2==1 && b%2==1)) {
			result = Math.max(a, b)*2;
		} else if((a%2==1 && b%2==0) || (a%2==0 && b%2==1)){
			result = Math.max(a, b)*2 -1;
		}
		
	}

}
