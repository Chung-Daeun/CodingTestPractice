import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int I, sr, sc, fr, fc;
    static int[][] dist;
    
    

    static void input() throws IOException {
        I = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken()); 
    }

    static int[][] dir = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    static int bfs(int r, int c) {
        Deque<int[]> bfsQue = new ArrayDeque<>();

        // 시작점 저장
        bfsQue.addLast(new int[]{r, c});

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();

            for (int i = 0; i < 8; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 경계 밖이면 스킵
                if (nr < 0 || nr >= I || nc < 0 || nc >= I) continue;

                if (dist[nr][nc] == 0) {
                    bfsQue.addLast(new int[]{nr, nc});
                    dist[nr][nc] = dist[current[0]][current[1]] + 1;
                }
            }
        }

        return dist[fr][fc];
    }
    
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            input();

            // 시작점과 끝점이 같은 경우는 0으로 처리하고 넘기기
            if (sr == fr && sc == fc) {
                sb.append(0).append("\n");
                continue;
            }
            
            dist = new int[I][I];
            sb.append(bfs(sr, sc)).append("\n");
        }

        br.close();

        System.out.println(sb);
    }
}