import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N;
    static String[] map;
    static List<Integer> group = new ArrayList<>();
    static boolean[][] visited;

    static class Pair {
        int r, c;

        Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

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

    static void findGroup(int r, int c) {
        Deque<Pair> bfsQue = new ArrayDeque<>();

        // 최초값 넣기
        bfsQue.addLast(new Pair(r, c));
        visited[r][c] = true;
        int cnt = 1;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while (!bfsQue.isEmpty()) {
            Pair nowhome = bfsQue.pollFirst();

            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + nowhome.r;
                int nc = dc[i] + nowhome.c;

                // 경계 밖 값의 경우 넘어가기 
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 방문여부 체크
                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;

                    // 집 유무 체크
                    if (map[nr].charAt(nc) == '1') {
                        cnt++;
                        bfsQue.addLast(new Pair(nr, nc));
                    }
                }
            }
        }

        // 단지 저장
        group.add(cnt);
    }

    static void pro() {
        visited = new boolean[N][N];
        
        // 단지 시작 잡 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i].charAt(j) == '1') {
                    findGroup(i, j);
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