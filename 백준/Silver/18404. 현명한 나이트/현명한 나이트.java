import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] enemyArr;
    static int[] me = new int[2];
    static int[][] dist;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        M = Integer.parseInt(st.nextToken());
        enemyArr = new int[M][2];

        st = new StringTokenizer(br.readLine());
        me[0] = Integer.parseInt(st.nextToken());
        me[1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            enemyArr[i][0] = Integer.parseInt(st.nextToken());
            enemyArr[i][1] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void pro() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            bfs();
        }

        for (int i = 0; i < M; i++) {
            sb.append(dist[enemyArr[i][0]][enemyArr[i][1]]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    static void bfs() {
        Deque<int[]> bfsQue = new ArrayDeque<>();

        // 현재 위치 저장
        bfsQue.addLast(me);

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 채스판을 벗어나면 스킵
                if (nr <= 0 || nr > N || nc <= 0 || nc > N) {
                    continue;
                }

                // 시작점이 아니고 이전에 방문한 곳이 아니면 거리 업데이트
                if ((nr != current[0] && nc != current[1]) && dist[nr][nc] == 0 ) {
                    bfsQue.addLast(new int[]{nr, nc});
                    dist[nr][nc] = dist[current[0]][current[1]] + 1;
                }
            }

        }
    }
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}