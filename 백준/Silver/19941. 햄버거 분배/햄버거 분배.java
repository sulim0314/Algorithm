import java.util.*;
import java.io.*;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        String line = br.readLine();
        boolean[] check = new boolean[N];
        for(int i=0; i<N; i++) {
            if(line.charAt(i) == 'P') {
                check[i] = true;
            }
        }

        int result = 0;
        for(int i=0; i<N; i++) {
            if(line.charAt(i) == 'P') {
                for(int j=(i-K); j<=(i+K); j++) {
                    if(j < 0 || j>= N || check[j]) continue;

                    check[j] = true;
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);


    }
}
