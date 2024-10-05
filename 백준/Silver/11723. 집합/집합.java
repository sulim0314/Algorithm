import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[21];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int n = -1;
            if(!s.equals("all") && !s.equals("empty")) {
                n = Integer.parseInt(st.nextToken());
            }

            if(s.equals("add")) {
                check[n] = true;
            } else if(s.equals("check")) {
                if(check[n]) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            } else if(s.equals("remove")) {
                check[n] = false;
            } else if(s.equals("toggle")) {
                if(check[n]) {
                    check[n] = false;
                } else {
                    check[n] = true;
                }
            } else if(s.equals("all")) {
                for(int j=0; j<21; j++) {
                    check[j] = true;
                }
            } else if(s.equals("empty")) {
                for(int j=0; j<21; j++) {
                    check[j] = false;
                }
            }
        }

        System.out.println(sb);

    }

}
