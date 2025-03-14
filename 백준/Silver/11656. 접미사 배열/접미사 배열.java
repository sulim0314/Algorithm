import java.util.*;
import java.io.*;


public class Main {

    static String[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        int len = line.length();
        arr = new String[len];

        for(int i=0; i<len; i++) {
            arr[i] = line.substring(i);
        }

        Arrays.sort(arr);
        for(int i=0; i<len; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);

    }

}
