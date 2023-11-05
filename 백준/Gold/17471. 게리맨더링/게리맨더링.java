import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] people;
	static ArrayList<Integer>[] list;
	static int min;
	
	static int[] data, num;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {

		// 1번부터 N번
		// 두 개의 선거구로 나눌 것, 각 선거구는 구역을 적어도 1개 포함.
		// 구역은 모두 연결.
		/* 첫째 줄에 백준시를 두 선거구로 나누었을 때, 
		두 선거구의 인구 차이의 최솟값을 출력한다. 
		두 선거구로 나눌 수 없는 경우에는 -1을 출력한다. */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		people = new int[N];
		list = new ArrayList[N];
		visited = new boolean[N];
		
		data = new int[N];
		num = new int[N];
		for(int i=0; i<N; i++) {
			data[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			for(int j=0; j<tmp; j++) {
				int to = Integer.parseInt(st.nextToken())-1;
				list[i].add(to);
			}
		}
		
		min = Integer.MAX_VALUE;
		subset(0,0);
		
		if(min == Integer.MAX_VALUE) {
		    System.out.println("-1");
		} else {
		    System.out.println(min);
		}
	}

	private static void subset(int cnt, int start) {

		for(int i = 0; i < N; i++) {
		    visited[i] = false;
		}
		
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			if(num[i] > 0) { // 부분집합 완성
				visited[num[i]] = true;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				aList.add(i);
			} else {
				bList.add(i);
			}
		}
		
		if(aList.size()>0 && bList.size()>0) {
			
			if(connected(aList) && connected(bList)) {
				// 두 지역구가 각각 연결되어있다면 인구 수 계산해서 min 계산
				int aPeople = 0;
				int bPeople = 0;
				for(int i=0; i<aList.size(); i++) {
					aPeople += people[aList.get(i)];
				}
				for(int i=0; i<bList.size(); i++) {
					bPeople += people[bList.get(i)];
				}
				min = Math.min(min, Math.abs(aPeople - bPeople));
			}
			
		}
		
		
		for(int i=start; i<N; i++) {
			num[cnt] = data[i];
			subset(cnt+1, i+1);
			num[cnt] = 0;
		}
	}

	private static boolean connected(ArrayList<Integer> arr) {

		Queue<Integer> q = new LinkedList<>();
		boolean[] visit = new boolean[N];
		int cnt = 1;
		q.add(arr.get(0));
		visit[arr.get(0)] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<list[cur].size(); i++) {
				int next = list[cur].get(i);
				if(arr.contains(next) && !visit[next]) {
					visit[next] = true;
					q.add(next);
					cnt++;
				}
			}
		}
		
		if(cnt == arr.size()) {
			return true;
		}
		return false;
	}

}
