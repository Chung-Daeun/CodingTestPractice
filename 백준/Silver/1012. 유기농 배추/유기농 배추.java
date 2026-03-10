import java.io.*;
import java.util.*;

public class Main {
    // 변수
    static int T, M, N, K;
    static byte[][] farm;
    static boolean[][] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        farm = new byte[M][N];
        visited = new boolean[M][N];

        // 배추 위치 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            farm[r][c] = 1;
        }

    }

    static void pro() {
        int worms = 0;

        // 그룹 시작점 찾기
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (farm[r][c] == 1 && !visited[r][c]) {
                    // 지렁이 갯수 추가
                    worms++;
                    // 인접한 배추 방문
                    dfs(r, c);
                }
            }
        }

        // 필요한 지렁이 수 출력
        System.out.println(worms);
    }

    static byte[] dr = {-1, 0, 0, 1};
    static byte[] dc = {0, -1, 1, 0};
    static void dfs(int r, int c) {
        // (만일 대비)  방문했던 배추의 경우 되돌려 보내기
        if (visited[r][c])  return;

        // 방문 표시
        visited[r][c] = true;

        // 상하좌우 움직이기
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 경계값 밖은 버리기
            if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;

            // 배추가 있고 방문하지 않았으면 방문하기
            if (farm[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            pro();
        }

        br.close();
        
    }
}