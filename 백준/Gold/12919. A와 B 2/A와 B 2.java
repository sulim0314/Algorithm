import java.util.*;
import java.io.*;

public class Main {
    
    static String S,T;
    static int sLen;
    static int result = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
        T = br.readLine();
        sLen = S.length();
        
        go(T);
        
        System.out.println(result);

    }
    
    private static void go(String t) {
        int tLen = t.length();
        if (tLen == sLen) {
            if (t.equals(S)) {
                result = 1;
            }
            return;
        }
        if (t.endsWith("A")) {
            go(t.substring(0, tLen - 1));
        }
        if (t.startsWith("B")) {
            go(new StringBuilder(t.substring(1)).reverse().toString());
        }
    }
    
}
