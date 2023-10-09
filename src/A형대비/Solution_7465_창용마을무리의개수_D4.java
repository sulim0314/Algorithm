package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_D4 {

	static int result = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[N];
			for(int i=0; i<N; i++) {
				list[i] = new ArrayList<>();
			}
			visited = new boolean[N];
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				list[a].add(b);
				list[b].add(a);
			}
			
			for(int i=0; i<N; i++) {
				if(visited[i]) continue;
				solve(i);
			}
			
			System.out.println("#"+tc+" "+result);
		}
		
	}

	private static void solve(int n) {

		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(visited[next]) continue;
				q.add(next);
				visited[next] = true;
			}
		}
		
		result++;
		
	}

}
/*
2
6 5
1 2
2 5
5 1
3 4
4 6
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
*/
