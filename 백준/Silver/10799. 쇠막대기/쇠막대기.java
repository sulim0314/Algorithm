import java.util.*;
import java.io.*;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> s = new Stack<>();
        for(int i=0; i<line.length(); i++) {
            if(line.charAt(i) == '(') {
                s.push('(');
                continue;
            }
            if(line.charAt(i) == ')') {
                s.pop();

                if(line.charAt(i-1) == '(') {
                    result += s.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
