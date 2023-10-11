package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취_정답 {

	static int max;
	static int N, M, C; // 맵사이즈, 벌통개수, 벌꿀채취량
	static int[][] map;
	static int[][] start;
	static boolean select[];
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int t = Integer.parseInt(st.nextToken());

		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			start = new int[N][N-M+1];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 수익 최대값, 수익 최대값의 위치 인덱스
			int profit=0, profitX=0, profitY=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-M+1; j++) {
					max = 0;
					select = new boolean[M]; // M개 고를 것임
					subset(0, i, j);
					if(profit < start[i][j]) {
						profit = start[i][j];
						profitX = i;
						profitY = j;
					}
				}
			} // start배열에 다 저장했고, profit 값도 구했음
			
			// 두번째로 큰 이익을 구해야함.
			int profit2 = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-M+1; j++) {
					if(i != profitX) {
						profit2 = Math.max(profit2, start[i][j]);
					} 
				}
			}
			
			int result = profit + profit2;
			System.out.println("#" + tc + " "+result);

		}
	}
	
	/**
	 * 선택한 M개의 벌꿀 통 안에서 부분집합으로 C를 넘지 않고 <이미 M개가 선택되어 있음. 여기서의 부분집합!>
	 * 이익이 최대인 구성 찾아서 start 배열에 저장함.
	 * @param idx : 체크한 개수, M이 되면 종료
	 * @param x : M개 가로 배열의 첫번째 x idx
	 * @param y : M개 가로 배열의 첫번째 y idx
	 */
	private static void subset(int idx, int x, int y) {

		// M개 중에 M개 까지 다 체크(true나 false로) 했을 때
		if(idx == M) {
			int sum=0, value=0;
			for(int i=0; i<M; i++) {
				if(select[i]) {
					sum += map[x][y+i];
					value += (map[x][y+i]) * (map[x][y+i]);
				}
			}
			if(sum <= C && max < value) {
				max = value;
				start[x][y] = value;
			}
			return;
		}
		
		select[idx] = true;
		subset(idx+1, x, y);
		select[idx] = false;
		subset(idx+1, x, y);
	}
}
