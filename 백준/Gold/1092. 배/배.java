import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Integer[] crane, box;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 항구에는 크레인 N대, 1분에 박스 1개씩 배에 싣기
		// 모든 크레인은 동시에 움직인다.
		// 각 크레인은 무게 제한이 있다.
		N = Integer.parseInt(st.nextToken());
		crane = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		box = new Integer[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crane, (o1, o2) -> o2-o1);
		Arrays.sort(box, (o1, o2) -> o2-o1);
		
		if(crane[0] < box[0]){
            System.out.println(-1);
            return;
        }
		
		int[] selectedTime = new int[M];
        Arrays.fill(selectedTime, -1);
        
        int t = 0;
        int cnt = 0;
        while(cnt < M) {
        	int c = 0; // crane index
        	int b = 0; // box index
        	while(c < N && b < M) {
        		// 이미 선택했을때 || 크레인이 집을 수 없을 때
        		if(selectedTime[b] != -1 || crane[c] < box[b]) {
        			b++;
        			continue;
        		}
        		selectedTime[b] = t;
        		c++;
        		b++;
        		cnt++;
        	}
        	t++;
        }
        
		System.out.println(t);
		
	}
}
