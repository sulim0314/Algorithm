import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int N, M;
	static int start, end, answer = 0;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			max = Math.max(max, weight);
			min = Math.min(min, weight);
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		// 이분탐색
		while(min <= max) {
			int mid = (min + max)/2;
			visited = new boolean[N+1];
			
			if(check(mid)) {
				min = mid + 1;
				answer = mid;
			} else {
				max = mid-1;
			}
		}
		System.out.println(answer);
	}

	private static boolean check(int num) {
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int data = q.poll();
			if(data == end) {
				return true;
			}
			
			for(int i=0; i<list[data].size(); i++) {
				Node nextNode = list[data].get(i);
				if(nextNode.weight >= num && !visited[nextNode.to]) {
					q.offer(nextNode.to);
					visited[nextNode.to] = true;
				}
			}
		}
		
		return false;
	}
}
