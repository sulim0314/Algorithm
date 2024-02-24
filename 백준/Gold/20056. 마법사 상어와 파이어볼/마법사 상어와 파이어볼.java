import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Info {
		int r, c, d, m, s;
		public Info(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}

	}
	
	static int N,M,K;
	static Queue<Info>[][] map;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // map N * N
		M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		K = Integer.parseInt(st.nextToken()); // K번 반복
		
		map = new LinkedList[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; // 행
			int c = Integer.parseInt(st.nextToken())-1; // 열
			
			int m = Integer.parseInt(st.nextToken()); // 질량
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken()); // 방향
			
			map[r][c].add(new Info(r,c,m,s,d));
		}
		
		// K번 반복
		for(int i=0; i<K; i++) {
			go();
			check();
		}
		
		int result = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() > 0) {
					while(!map[i][j].isEmpty()) {
						Info curInfo = map[i][j].poll(); 
						result += curInfo.m;
					}
				}
			}
		}
		
		System.out.println(result);
	}

	private static void check() { // 파이어볼 소멸

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				if(map[i][j].size() > 1) {
					int mSum = 0;
					int sSum = 0;
					int[] arr = new int[2];
					int fireballCount = map[i][j].size();
					while(!map[i][j].isEmpty()) {
						Info curInfo = map[i][j].poll(); 
						mSum += curInfo.m;
						sSum += curInfo.s;
						if(curInfo.d%2 == 0) {
							arr[0] = 1;
						} else {
							arr[1] = 1;
						}
					}
					int sameM = mSum/5;
					if(sameM != 0) {
						int sameS = sSum/fireballCount;
						if(arr[0] + arr[1] == 1) {
							map[i][j].add(new Info(i, j, sameM, sameS, 0));
							map[i][j].add(new Info(i, j, sameM, sameS, 2));
							map[i][j].add(new Info(i, j, sameM, sameS, 4));
							map[i][j].add(new Info(i, j, sameM, sameS, 6));
						} else {
							map[i][j].add(new Info(i, j, sameM, sameS, 1));
							map[i][j].add(new Info(i, j, sameM, sameS, 3));
							map[i][j].add(new Info(i, j, sameM, sameS, 5));
							map[i][j].add(new Info(i, j, sameM, sameS, 7));
						}
					}
					
				}
			}
		}
		
	}

	private static void go() {

		Queue<Info>[][] tempMap = new LinkedList[N][N];
	    for(int i=0; i<N; i++) {
	        for(int j=0; j<N; j++) {
	            tempMap[i][j] = new LinkedList<>();
	        }
	    }
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() > 0) {
					while(!map[i][j].isEmpty()) {
						Info curInfo = map[i][j].poll(); 
						move(curInfo, tempMap);
					}
				}
			}
		}
		map = tempMap;
	}

	private static void move(Info curInfo, Queue<Info>[][] tempMap) {
	    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

	    int nr = (curInfo.r + dr[curInfo.d] * curInfo.s % N + N) % N;
	    int nc = (curInfo.c + dc[curInfo.d] * curInfo.s % N + N) % N;

	    curInfo.r = nr;
	    curInfo.c = nc;
	    tempMap[nr][nc].add(curInfo);
	}
}
