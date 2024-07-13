import java.util.*;
import java.io.*;

// 분할정복
public class Main {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        divide(0, 0, N);
        for (int i = 0; i < N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] != '*') {
                    sb.append(' ');
                } else {
                    sb.append('*');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    private static char divide(int x, int y, int size) {

        if (size == 1) {
            map[x][y] = '*';
            return '*';
        }

        int[] arr = new int[9];

        arr[0] = divide(x, y, size/3);
        arr[1] = divide(x, y+size/3, size/3);
        arr[2] = divide(x, y+2*size/3, size/3);
        arr[3] = divide(x+size/3, y, size/3);
        // 중앙은 blank
        arr[4] = ' ';
        arr[5] = divide(x+size/3, y+2*size/3, size/3);
        arr[6] = divide(x+2*size/3, y, size/3);
        arr[7] = divide(x+2*size/3, y+size/3, size/3);
        arr[8] = divide(x+2*size/3, y+2*size/3, size/3);

        if (arr[0] == '*' && arr[1] == '*' && arr[2] == '*' && arr[3] == '*' && arr[5] == '*' && arr[6] == '*' && arr[7] == '*' && arr[8] == '*') {
            map[x+size/3][y+size/3] = ' ';
        } else {
            map[x+size/3][y+size/3] = '*';
        }

        return '*';
    }

}
