package sulim;

import java.util.Scanner;

public class algo_15649_visit_flag {

	static int N;
	static int M;
	static int[] data; // 뽑을 원소를 저장하는 배열
	static int[] num; // 뽑은 원소를 저장하는 배열
	static boolean[] visit; // 원소 사용의 중복을 체크해주는 배열

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 4
		M = sc.nextInt(); // 2

		data = new int[N];
		num = new int[M];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			data[i] = i + 1; // 1 2 3 4
		}

		permutation_visit(0);
		permutation_flag(0,0);
	}

	private static void permutation_visit(int cnt) {
		if (cnt == M) {// 2까지 접근 가능
			for (int i = 0; i < M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}

		// data 배열 수만큼 반복 i는 data배열의 index
		for (int i = 0; i < N; i++) {
			// 중복검사
			if (visit[i]) {
				continue;
			}
			num[cnt] = data[i];

			visit[i] = true;

			permutation_visit(cnt + 1);

			visit[i] = false;
		}

	}
	
	private static void permutation_flag(int cnt, int flag) {
		
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(num[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// data 배열 수만큼 반복 i는 data배열의 index
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) {
				continue;
			}
			num[cnt] = data[i];
			permutation_flag(cnt+1, flag | 1<<i);
		}
	}
}
