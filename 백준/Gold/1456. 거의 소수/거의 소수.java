import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long M = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        int n = (int)Math.sqrt(10_000_000) + 1;
        
        boolean[] nums = new boolean[10_000_001];

        nums[1] = true;
        for(int i=2; i<n+1; i++) { // 본인꺼 빼고 본인 배수들은 true로.
        	if(nums[i]) {
        		continue;
        	}
        	for(int j=i+i; j<10_000_001; j+=i) {
        		nums[j] = true;
        	}
        }
        
        
        int cnt = 0;
        long curr;
        for(int i=2; i<10_000_001; ++i) {
        	if(nums[i]) continue;
        	
        	for(int k=2; k<57; ++k) {
        		curr = (long) Math.pow(i, k);
        		
        		if(curr < M) continue;
        		if(curr > N) break;
        		
        		++cnt;
        	}
        }
        
        
        
        System.out.print(cnt);
        br.close();
        
	}

}
