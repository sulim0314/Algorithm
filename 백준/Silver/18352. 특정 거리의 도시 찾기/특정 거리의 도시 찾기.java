import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, X;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=0; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		visited[X] = true;
		int[] arr = new int[N+1];
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			cnt = arr[cur]+1;
			
			for(int i=0; i<list[cur].size(); i++) {
				if(!visited[list[cur].get(i)]) {
					q.add(list[cur].get(i));
					visited[list[cur].get(i)] = true;
					arr[list[cur].get(i)] = cnt;
				}
			}
		}
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if(arr[i] == K) {
				flag = true;
				System.out.println(i);
			}
		}
		if(!flag) {
			System.out.println(-1);
		}
		
	}

}
