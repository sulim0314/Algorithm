import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int[] parents;
	
	static void make() {
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i; 
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false; // 사이클 발생
		}
		parents[bRoot] = aRoot;
		return true;
	}
	
	static int N;
	static ArrayList<xy> list = new ArrayList<>();
	static class xy {
		double x,y;
		public xy(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new xy(x,y));
		}
		
		
		edgeList = new Edge[N*N-N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i == j) {
					continue;
				}
				int from = i;
				int to = j;
				double weight = Math.pow((list.get(i).x - list.get(j).x),2)+Math.pow((list.get(i).y - list.get(j).y),2);
				weight = Math.sqrt(weight);
				edgeList[cnt] = new Edge(from, to, weight);
				cnt++;
			}
		}
		
		Arrays.parallelSort(edgeList);
		
		make();
		
		double result = 0;
		int count = 0;
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				result += edge.weight;
				if(++count == N-1) break;
			}
		}
		
		System.out.printf("%.2f",result);
		
	}

}
