package com.sulim.study_0817;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class xy {
	int x;
	int y;
	public xy(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution_1949_등산로조성_고수림 {

	static int T,N,K;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<xy> list;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int result;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for(int test=1; test<=T; test++) {
			result = 0;
			int max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) {
						list = new ArrayList<>();
						max = map[i][j];
						list.add(new xy(i,j));
					} else if(map[i][j] == max) {
						list.add(new xy(i,j));
					}
				}
			}
			
			for(int i=0; i<list.size(); i++) {
				visited[list.get(i).x][list.get(i).y] = true;
				dfs(list.get(i).x, list.get(i).y, map[list.get(i).x][list.get(i).y], 1, false);
				visited[list.get(i).x][list.get(i).y] = false;
			}
			
			
			System.out.println("#"+test+" "+result);
		}
		
	}

	private static void dfs(int x, int y, int value, int cnt, boolean flag) {

		visited[x][y] = true;
		result = Math.max(cnt, result);
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				
				if(visited[nx][ny]) continue;
				
				if(!flag && !visited[nx][ny] && (value <= map[nx][ny])) {
					for(int k=1; k<=K; k++) {
						int tmp = map[nx][ny] - k;
						if(tmp < value) {
							visited[nx][ny] = true;
							dfs(nx,ny,tmp,cnt+1,true);
							visited[nx][ny] = false;
						}
					}
				} 
				
				if(value > map[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx,ny,map[nx][ny],cnt+1,flag);
					visited[nx][ny] = false;
				}
				
			}
			
		}
		
		
		
	}
}
















