import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N;
    static String[] map;
    static List<Integer> group = new ArrayList<>();
    static boolean[][] visited;

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine();
        }

        br.close();
    }

    static void dfs(int r, int c) {

        // 이미 방문했던 곳이면 패스
        if (visited[r][c])  return;

        // 최초값 넣기
        visited[r][c] = true;
        cnt++;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        // 상하좌우 확인
        for (int i = 0; i < 4; i++) {
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            // 경계 밖 값의 경우 넘어가기 
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            // 집인경우
            if (map[nr].charAt(nc) == '1') {
                dfs(nr, nc);
            }
        }

    }

    static int cnt;
    static void pro() {
        visited = new boolean[N][N];
        
        // 단지 시작 잡 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i].charAt(j) == '1') {
                    cnt = 0;
                    dfs(i, j);
                    group.add(cnt);
                }
            }
        }
    }

    static void answer() {
        Collections.sort(group);

        System.out.println(group.size());
        for (int num : group) {
            System.out.println(num);
        }
    }

    // 실행
    public static void main(String[] args) throws Exception {
        input();
        pro();
        answer();
    }
}