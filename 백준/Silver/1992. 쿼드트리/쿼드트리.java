import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    static int N;
    static int[][] map;
    static String result="";

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        
        for(int i=0; i<N; i++) {
        	String tempS = br.readLine();
        	for(int j=0; j<N; j++) {
        		map[i][j] = tempS.charAt(j)-'0';
        	}
        }
        
        check(0, 0, N);
        System.out.println(result);
        
    }
    
    private static void check(int x, int y, int size) {
        
    	int sum = 0;
    	
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				sum += map[i][j];
			}
		}
		
		int half = size/2;
		
		if (sum == 0) {
			result += "0";
		} else if (sum == size*size) {
			result += "1";
		} else {
			result += "(";
			check(x, y, half);
			check(x, y+half, half);
			check(x+half, y, half);
			check(x+half, y+half, half);
			result += ")";
		}
    	
    	
        
    }
    


    
    
    
}
