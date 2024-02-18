import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] ta_arr;
	
	static int[] data,num;
	static boolean[] visit;
	
	static int n; // 이닝
	static int[] base;
	static int score;
	static int max;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        n = Integer.parseInt(st.nextToken()); // 이닝
        arr = new int[n][9]; //이닝 개수만큼에 넣을거임. // 0 ~ 8 번 타자가 칠 것들
        
        for(int a=0; a<n; a++) {
        	st = new StringTokenizer(br.readLine());
        	for(int i=0; i<9; i++) {
        		int temp = Integer.parseInt(st.nextToken());
        		arr[a][i] = temp;
        	}
        }
        
        ta_arr = new int[9]; // 타순 
        
        // 1번 선수는 꼭 4번타자임. (꼭 3번째 자리에 있어야함)
        // 순열로 8명 배치해야함. ( 이닝만큼.. 해야함..)
        data = new int[8]; // 0부터 7까지. 8개
        for(int i=0; i<8; i++) {
        	data[i] = i;
        }
        num = new int[8]; // 조합해서 타순 넣기
        visit = new boolean[8];
        
        per_visit(0);
        
		System.out.println(max);
		
	}

	// 8개 중에서 8개 뽑기. 
	private static void per_visit(int cnt) {
		
		if(cnt == 8) {
			// 순열 완성됐을 때
			put();
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(visit[i]) {
				continue;
			}
			num[cnt] = data[i];
			visit[i] = true;
			per_visit(cnt+1);
			visit[i] = false;
		}
		
	}

	// 0~2는 0,1,2 자리로 가고, 3에는 원래 최애선수, 4~8에(5명)에는 나머지 3~7 넣기 
	// 타순을 넣는거임 !!!!
	private static void put() {
		
		for(int i=0; i<3; i++) {
			ta_arr[i] = num[i]+1; 
		}
		
		ta_arr[3] = 0;
		
		for(int i=3; i<8; i++) {
			ta_arr[i+1] = num[i]+1;
		}
		simul(); // score 계산.

		max = Math.max(max, score);
		
	}

	private static void simul() {

		int out = 0;
		int e = 0;  // 1번째 이닝부터 시작.
		int nn = 0; // 처음 타자부터 시작할거임.
		score = 0;

		// base[0]에는 치는 사람, base[1]은 1루, base[2]=2루, base[3]=3루
        base = new int[4];
        
		while(e < n) {
			// 타자 실행.
			base[0] = 1;
			if(arr[e][ta_arr[nn]] == 0) { // 아웃일 때
				base[0] = 0;
				out++;
				
				// 이닝 끝남
				if(out == 3) {
					base[0] = 0;
					base[1] = 0;
					base[2] = 0;
					base[3] = 0;
					out = 0;
					e++;
				}
			} else if(arr[e][ta_arr[nn]] == 1) { // 안타
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				}
				base[3] = base[2];
				base[2] = base[1];
				base[1] = base[0];
				base[0] = 0;
			} else if(arr[e][ta_arr[nn]] == 2) { // 2루타
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				} 
				base[3] = base[1];
				base[2] = base[0];
				base[1] = 0;
				base[0] = 0;
			} else if(arr[e][ta_arr[nn]] == 3) { // 3루타
				if(base[1] == 1) {
					score++;
					base[1] = 0;
				}
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				} 
				base[3] = base[0];
				base[0] = 0;
			} else if(arr[e][ta_arr[nn]] == 4) { // 홈런
				score++;
				if(base[1] == 1) {
					score++;
					base[1] = 0;
				}
				if(base[2] == 1) {
					score++;
					base[2] = 0;
				}
				if(base[3] == 1) {
					score++;
					base[3] = 0;
				} 
				base[0] = 0;
			}
			nn++;
			
			if(nn == 9) {
				nn = 0;
			}
			
			
		} // while
		
	}

}


