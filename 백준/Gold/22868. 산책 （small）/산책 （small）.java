import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int to, weight;
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int N, M, S, E, result;
	static ArrayList<Integer>[] list;
	static int[] path;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 정점 개수 N, 도로 개수 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		path = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list[from].add(to);
			list[to].add(from);
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		// 정점을 오름차순으로 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(list[i]);
		}
		
		// 시작부터 정점까지 가기
		go(S, E);
		Arrays.fill(visited, false);
		
		// 다음 정점 = 현재 정점
		int k = path[E];
		
		while(k > 0) {
			visited[k] = true;
			k = path[k];
		}
		
		visited[S] = false;
		go(E, S);
		System.out.println(result);

	}

	private static void go(int s, int e) {

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s,0));
		visited[s] = true;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int cur = curNode.to;
			
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(!visited[next]) {
					visited[next] = true;
					path[next] = cur;
					q.add(new Node(next, curNode.weight+1)); 
				}
				if(next == e) {
					result += curNode.weight+1; 
					return;
				}
			}
		}
		
		
		
	}

}
