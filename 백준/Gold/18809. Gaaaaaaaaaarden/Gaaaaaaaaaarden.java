import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int G, R;
    static int[][] garden;
    static List<int[]> possibleLands;
    static int[] selected;
    static int[] greenSelected;
    static int answer;

    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static class Node {
        int r;
        int c;
        int t;
        char color;

        public Node (int r, int c, int t, char color) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.color = color;
        }
    }

    static boolean check(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    /*
        1. 배양액을 뿌릴 수 있는 땅 중 (G + R)개 뽑기
     */
    static void selectLand(int start, int count) {
        if (count == (G + R)) {
            selectGreen(0, 0);
            return;
        }

        for (int i = start; i < possibleLands.size(); i++) {
            selected[count] = i;
            selectLand(i + 1, count + 1);
        }
    }

    /*
        2. 뽑은 땅에서 G개 뽑기
     */
    static void selectGreen(int start, int count) {
        if (count == G) {
            bfs();
            return;
        }

        for (int i = start; i < G + R; i++) {
            greenSelected[count] = i;
            selectGreen(i + 1, count + 1);
        }
    }

    /*
        3. 배양액 뿌리기
     */
    static void bfs() {
        int[][] greenTime = new int[N][M];
        int[][] redTime = new int[N][M];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < G + R; i++) {
            boolean check = false;

            for (int j = 0; j < G; j++) {
                if (greenSelected[j] == i) {
                    check = true;
                }
            }

            if (check) {
                int[] land = possibleLands.get(selected[i]);
                greenTime[land[0]][land[1]] = 1;
                queue.offer(new Node(land[0], land[1], 1, 'G'));
                continue;
            }

            int[] land = possibleLands.get(selected[i]);
            redTime[land[0]][land[1]] = 1;
            queue.offer(new Node(land[0], land[1], 1, 'R'));
        }

        int count = 0;
        while (!queue.isEmpty()) {
            Node now = queue.poll();

			// 꽃이 핀 경우
            if (greenTime[now.r][now.c] == redTime[now.r][now.c]) {
                continue;
            }

            for (int[] d : directions) {
                int nr = now.r + d[0];
                int nc = now.c + d[1];

                if (!check(nr, nc)) {
                    continue;
                }

                if (garden[nr][nc] == 0) {
                    continue;
                }

				// 초록색 배양액인 경우
                if (now.color == 'G') { 
                	// 이미 초록색 배양액을 뿌린 경우
                    if (greenTime[nr][nc] > 0) { 
                        continue;
                    }
					
                    // 이미 빨간색 배양액을 뿌린 경우
                    if (redTime[nr][nc] > 0 && redTime[nr][nc] <= now.t) {
                        continue;
                    }

                    greenTime[nr][nc] = now.t + 1;

					// 꽃이 피는 경우
                    if (redTime[nr][nc] == now.t + 1) {
                        count++;
                        continue;
                    }

                    queue.offer(new Node(nr, nc, now.t + 1, now.color));
                    continue;
                }

				// 빨간색 배양액인 경우
                
                // 이미 빨간색 배양액을 뿌린 경우
                if (redTime[nr][nc] > 0) {
                    continue;
                }

				// 이미 초록색 배양액을 뿌린 경우
                if (greenTime[nr][nc] > 0 && greenTime[nr][nc] <= now.t) {
                    continue;
                }

                redTime[nr][nc] = now.t + 1;

				// 꽃이 피는 경우
                if (greenTime[nr][nc] == now.t + 1) {
                    count++;
                    continue;
                }

                queue.offer(new Node(nr, nc, now.t + 1, now.color));
            }
        }

        answer = Math.max(answer, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        garden = new int[N][M];
        possibleLands = new ArrayList<>();
        answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                garden[i][j] = Integer.parseInt(st.nextToken());

                if (garden[i][j] == 2) {
                    possibleLands.add(new int[] {i, j});
                }
            }
        }

        selected = new int[G + R];
        greenSelected = new int[G];
        selectLand(0, 0);

        System.out.println(answer);
        br.close();
    }
}