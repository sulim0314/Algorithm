import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class xy {
	int x,y;

	public xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Main {
	
	static int r,c;
	static char[][] map;
	static int b_x, b_y;
	static int g_x, g_y;
	static ArrayList<xy> water = new ArrayList<>();;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		visited = new boolean[r][c];
		
		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'D') { // 비버굴
					b_x = i;
					b_y = j;
				} else if(map[i][j] == '*') { // 물
					water.add(new xy(i,j));
				} else if(map[i][j] == 'S') { // 고슴이
					g_x = i;
					g_y = j;
				}
			}
		}
		
		Queue<xy> water_q = new LinkedList<>();
		Queue<xy> gosm_q = new LinkedList<>();
		
		gosm_q.offer(new xy(g_x,g_y));
		
		for(int i=0; i<water.size(); i++) {
			water_q.offer(water.get(i));
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int time = 0;
		
		while(true) {
			int water_size = water_q.size();
			while(0 < water_size) {
				
				// 물칠하기
				xy wt = water_q.poll();
				
				for(int i=0; i<4; i++) {
					int nx = wt.x+dx[i];
					int ny = wt.y+dy[i];
					if(0<=nx && nx<r && 0<=ny && ny<c && map[nx][ny] =='.') {
						map[nx][ny] = '*';
						water_q.offer(new xy(nx,ny));
					}
				}
				water_size--;
			}
			
			int gosm_size = gosm_q.size();
			
			while(0 < gosm_size) {
				
				xy gt = gosm_q.poll();
				visited[gt.x][gt.y] = true;
				
				for(int i=0; i<4; i++) {
					int nx = gt.x+dx[i];
					int ny = gt.y+dy[i];
					if(0<=nx && nx<r && 0<=ny && ny<c) {
						if(map[nx][ny] =='.') {
							visited[nx][ny] = true;
							map[nx][ny] = 'S';
							gosm_q.offer(new xy(nx,ny));
						} else if(map[nx][ny] =='D') {
							System.out.println(time+1);
							return;
						}
					}
				}
				gosm_size--;
			}

			if(gosm_q.isEmpty()) {
				System.out.println("KAKTUS");
				return;
			}
			
			time++;
			
		}
		
	}

}
