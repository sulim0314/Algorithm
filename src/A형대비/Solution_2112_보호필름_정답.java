package A형대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름_정답 {

	static int result;
	static int D,W,K;
	static int[][] map;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int t = Integer.parseInt(st.nextToken());
		
		for(int tc=1; tc<=t; tc++) {
			result = Integer.MAX_VALUE;			
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			arr = new int[D];
			
			Arrays.fill(arr, -1);
			// 현재 몇번째의 막의 정보를 수정하고 있는지, 현재까지 몇번 막의 정보를 수정했는지
            dfs(0,0);
			System.out.println("#"+tc+" "+result);
		}
		
	}

	private static void dfs(int idx, int cnt) {

		if(cnt >= result) {
			return;
		}
		
		if(idx == D) {
			// 막 안전검사
			if(check()) {
				result = Math.min(result, cnt);
			}
			return;
		}
		
		//실행하면서 재귀호출
        // 막의 정보를 처리 X, 막의 정보 0 (A약품으로 처리), 막의 정보를 1(B약품으로 처리)
        arr[idx] = -1;
        dfs(idx+1, cnt);
        
//        막의 정보 0,
        arr[idx] = 0;
        dfs(idx+1, cnt + 1);
        
//        막의 정보를 1
        arr[idx] = 1;
        dfs(idx+1, cnt + 1);
		
		
	}

	private static boolean check() {
        int cnt = 0;
        int a, b;
        for(int j =0; j < W; j++) {
            cnt = 1;
            
            for(int i = 0; i < D-1; i++) {
                a = map[i][j];
                b = map[i+1][j];
                //막이 변경되었으면 변경된값을 확인하기
                if(arr[i] != -1) {
                    a = arr[i];
                }
                if(arr[i+1] != -1) {
                    b = arr[i+1];
                }
                
                //같냐 비교
                if(a == b) {
                    cnt++;
                    //현재위치에서 이미안전하다고 판단된 결과 이니 다음열로 넘어가기
                    if(cnt >= K) {
                        break;
                    }
                }else {
                    cnt = 1;
                }
            }
            
            if(cnt < K) {
                return false;
            }
        }
        return true;
    }

}
