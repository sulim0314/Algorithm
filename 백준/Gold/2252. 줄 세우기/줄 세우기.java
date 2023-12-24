import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	
	static int[] inDegree; // 각 노드의 진입차수
	static ArrayList<Integer>[] adjLists;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adjLists = new ArrayList[N + 1];
		
		for(int i=0; i<=N; i++) {
			adjLists[i] = new ArrayList<Integer>();
		}
		
		// 각 노드의 진입차수
		inDegree = new int[N + 1];
		
		// 방향 그래프
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int head = Integer.parseInt(st.nextToken());
			int adj = Integer.parseInt(st.nextToken());
			adjLists[head].add(adj); // 단방향 연결 설정
			inDegree[adj]++; // 후행 정점 진입 차수 증가
		}
		
		// 위상 정렬 (A B: A가 B앞에 선다. A가 선행)
		topologicalSort();
		
	}

	private static void topologicalSort() {

		Queue<Integer> q = new LinkedList<>();
		
		// 초기: 선행 정점을 가지지 않은 정점을 큐에 저장.
		for(int i=1; i<=N; i++) {
			if(inDegree[i] == 0) { // 진입차수가 0인 노드 저장
				q.add(i);
			}
		}
		
		// 정점의 개수 만큼 반복
		for(int i=0; i<N; i++) {
			int N = q.poll(); // 1.큐에서 정점 후보 추출 및 삭제
			sb.append(N+" ");

			// 2. 해당 정점과 연결된 모든 정점에 대해
			//for (int nextV : adjLists[N]) {
			for (int j=0,size=adjLists[N].size(); j<size; j++) {
				int nextV = adjLists[N].get(j);
				inDegree[nextV]--;// 2.1 진입 차수 감소

				// 2-2. 선행 정점을 가지지 않는 정점을 큐에 저장
				if (inDegree[nextV] == 0) {
					q.add(nextV);
				}
			}
		}
		
		System.out.println(sb);
		
	}

}
