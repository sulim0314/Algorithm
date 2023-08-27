package com.sulim.study_0826토;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_고수림 {
	static class xy {
		int x,y;
		public xy(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int[][] map, map_og;
	static int coreMax, length, already;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static ArrayList<xy> list;
	static int[] data, num;
	static int tmpCnt, tmpLength;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			coreMax=0; already=0; length=Integer.MAX_VALUE;
			map = new int[N][N];
			map_og = new int[N][N];
			list = new ArrayList<>();
			
			// map에 넣기
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					int temp = Integer.parseInt(st.nextToken());
					map[i][j] = temp;
					map_og[i][j] = temp;
					if(map[i][j] != 0) {
						if(i == 0 || i == N-1 || j == 0 || j == N-1) {
							already++;
						} else { // 이미 연결되어있지 않은건 연결해야하니까 list에 넣는다.
							list.add(new xy(i, j));
						}
					}
				}
			}
			
			// 중복순열을 위한 data와 num 배열
			// 4개 중에서 n개 뽑는거네..
			int n = list.size();
			data = new int[4];
			num = new int[n];
			for(int i=0; i<4; i++) {
				data[i] = i;
			}
			
			per(0);
			sb.append("#").append(tc).append(" ").append(length).append("\n");
		}
		
		System.out.println(sb.toString());
	    br.close();

	}

	private static void per(int cnt) {
		tmpCnt = 0;
		tmpLength = 0;
		
	    if (cnt == list.size()) { // 중복순열 완성
	    	mapCopy();
	    	for(int i=0; i<list.size(); i++) {
				check(list.get(i).x, list.get(i).y, num[i]);
				if(tmpCnt+(list.size()-1-i) < coreMax) {
					return;
				}
	    	}
	    	if(coreMax == tmpCnt) { // 최대연결개수가 똑같다면
	    		length = Math.min(length, tmpLength);
	    	} 
	    	if(coreMax < tmpCnt) {
	    		coreMax = tmpCnt;
	    		length = tmpLength;
	    	}
	        return;
	    }

	    for (int i = 0; i < 4; i++) {
	        num[cnt] = data[i];
	        per(cnt + 1);
	    }
	}

	private static void mapCopy() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = map_og[i][j];
			}
		}
	}

	// 갔던 곳 표시해줘야함
	private static void check(int a, int b, int n) {
		
		int nx = a + dx[n];
		int ny = b + dy[n];
		
		// 범위 안에 있을 때
		if(0<=nx && nx <N && 0<=ny && ny <N) {
			// 다음 칸에 아무것도 없을 때
			if(map[nx][ny] == 0) {
				map[nx][ny] = 1;
				tmpLength++;
				// 벽에 닿으면 연결된거임
				if(nx == 0 || nx == N-1 || ny == 0 || ny == N-1) {
					tmpCnt++;
				}
				check(nx, ny, n);
			} 
		} else {
			return;
		}
		
	}

}


/*
1
7
0 0 0 1 0 0 0
0 0 0 0 0 0 0
0 0 0 0 0 0 0
1 0 0 1 0 0 1
0 0 0 0 0 0 0
0 0 0 0 0 0 0
0 0 0 1 0 0 0
*/
