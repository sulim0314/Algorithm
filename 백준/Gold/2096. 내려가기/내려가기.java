import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] dp1, dp2;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		map = new int[n][3];
		dp1 = new int[n][3];
		dp2 = new int[n][3];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<3; i++) {
			dp1[0][i] = map[0][i];
			dp2[0][i] = map[0][i];
		}
		
		for(int i=1; i<n; i++) {
			dp1[i][0] = Math.max(map[i][0]+dp1[i-1][0], map[i][0]+dp1[i-1][1]);
			dp1[i][1] = Math.max(Math.max(map[i][1]+dp1[i-1][0], map[i][1]+dp1[i-1][1]), map[i][1]+dp1[i-1][2]);
			dp1[i][2] = Math.max(map[i][2]+dp1[i-1][1], map[i][2]+dp1[i-1][2]);
		
			dp2[i][0] = Math.min(map[i][0]+dp2[i-1][0], map[i][0]+dp2[i-1][1]);
			dp2[i][1] = Math.min(Math.min(map[i][1]+dp2[i-1][0], map[i][1]+dp2[i-1][1]), map[i][1]+dp2[i-1][2]);
			dp2[i][2] = Math.min(map[i][2]+dp2[i-1][1], map[i][2]+dp2[i-1][2]);
		}
		
		int max = Math.max(Math.max(dp1[n-1][0], dp1[n-1][1]), dp1[n-1][2]);
		int min = Math.min(Math.min(dp2[n-1][0], dp2[n-1][1]), dp2[n-1][2]);
		
		System.out.println(max+" "+min);
	}

}
