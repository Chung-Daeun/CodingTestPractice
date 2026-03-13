import java.io.*;
import java.util.*;

class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int w, h;

    static void input() throws IOException {
        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static void bfs(int r, int c) {
        Deque<int[]> bfsQue = new ArrayDeque<>();

        bfsQue.addLast(new int[]{r, c});
        visited[r][c] = true;

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                // 경계 밖 제외
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) {
                    continue;
                }

                // 섬이고 방문 전인 곳만 넣기
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    bfsQue.addLast(new int[]{nr, nc});
                }
            }
        }
    }

    static void pro() {
        int cnt = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {

        while (1 == 1) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (w == 0 && h == 0) {
                break;
            }

            input();
            pro();
        }
        br.close();
    }
}