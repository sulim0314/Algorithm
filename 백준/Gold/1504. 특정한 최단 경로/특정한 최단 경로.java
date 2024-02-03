import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Info implements Comparable<Info> {
		int to, weight;

		public Info(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Info o) {
			return this.weight - o.weight;
		}
		
	}
	
	static int N, E;
	static ArrayList<Info>[] list;
	
	static int[] dist;
	static boolean[] check;
	static int INF = 200000000;
	
	public static void main(String[] args) throws Exception {
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
     
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수
        list = new ArrayList[N];
        for(int i=0; i<N; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken())-1;
        	int to = Integer.parseInt(st.nextToken())-1;
        	int weight = Integer.parseInt(st.nextToken());
        	
        	list[from].add(new Info(to, weight));
        	list[to].add(new Info(from, weight)); // 양방향
        }
		
        st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		
		dist = new int[N];
		check = new boolean[N];
		
		int result1 = dk(0, a) + dk(a, b) + dk(b, N-1);
		int result2 = dk(0, b) + dk(b, a) + dk(a, N-1);
		
		int result = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);
		System.out.println(result);
		
	}

	private static int dk(int start, int end) {

		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			int cur = info.to;
			
			if(!check[cur]) {
				check[cur] = true;
				
				for(int i=0; i<list[cur].size(); i++) {
					Info curInfo = list[cur].get(i);
					if(!check[curInfo.to]) {
						if(dist[curInfo.to] > dist[cur] + curInfo.weight) {
							dist[curInfo.to] = dist[cur] + curInfo.weight;
							pq.add(new Info(curInfo.to, dist[curInfo.to]));
						}
					}
				}
			}
		}
		
		return dist[end];
	}

}
