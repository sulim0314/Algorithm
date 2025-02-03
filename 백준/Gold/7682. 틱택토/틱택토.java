import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String board = br.readLine();
            if (board.equals("end")) break;

            if (isValid(board)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isValid(String board) {
        int xCount = 0, oCount = 0;

        for (char c : board.toCharArray()) {
            if (c == 'X') xCount++;
            if (c == 'O') oCount++;
        }

        if (oCount > xCount || xCount > oCount + 1) return false;

        boolean xWin = checkWin(board, 'X');
        boolean oWin = checkWin(board, 'O');

        if (xWin && oWin) return false;

        if (xWin && xCount == oCount + 1) return true;

        if (oWin && xCount == oCount) return true;

        if (!xWin && !oWin && xCount + oCount == 9) return true;

        return false;
    }

    // 승리 조건 체크 (가로, 세로, 대각선 확인)
    private static boolean checkWin(String board, char player) {
        char[][] grid = new char[3][3];

        for (int i = 0; i < 9; i++) {
            grid[i / 3][i % 3] = board.charAt(i);
        }

        // 가로, 세로 체크
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == player && grid[i][1] == player && grid[i][2] == player) return true; // 가로
            if (grid[0][i] == player && grid[1][i] == player && grid[2][i] == player) return true; // 세로
        }

        // 대각선 체크
        if (grid[0][0] == player && grid[1][1] == player && grid[2][2] == player) return true;
        if (grid[0][2] == player && grid[1][1] == player && grid[2][0] == player) return true;

        return false;
    }
}
