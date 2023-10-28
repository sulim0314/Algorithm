import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {  

	static int[][] map;
	static int n; 
	static int cnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		dfs(0,1,1);
		System.out.println(cnt);
		
	}

	private static void dfs(int x, int y, int state) {

		if(x == n-1 && y == n-1) {
			cnt++;
			return;
		}
		switch(state) {
		case 1:
			if(y+1 < n && map[x][y+1] == 0) {
				dfs(x, y+1,1);
			} 
			if(y+1 < n && x+1 < n && map[x+1][y+1]+map[x+1][y]+map[x][y+1] == 0) {
				dfs(x+1,y+1,3);
			}
			break;
		case 2:
			if(x+1 < n && map[x+1][y] == 0) {
				dfs(x+1,y,2);
			}
			if(y+1 < n && x+1 < n && map[x+1][y+1]+map[x+1][y]+map[x][y+1] == 0) {
				dfs(x+1,y+1,3);
			}
			break;
		case 3:
			if(y+1 < n && map[x][y+1] == 0) {
				dfs(x, y+1,1);
			} 
			if(x+1 < n && map[x+1][y] == 0) {
				dfs(x+1,y,2);
			}
			if(y+1 < n && x+1 < n && map[x+1][y+1]+map[x+1][y]+map[x][y+1] == 0) {
				dfs(x+1,y+1,3);
			}
			break;
		}
		
	}

}
