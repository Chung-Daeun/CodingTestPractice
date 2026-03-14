import java.io.*;
import java.util.*;

class Main {
    
    static int R, C;
    static String[] backyard;
    static boolean[][] visited;
    static int Lsheep = 0,  Lwolf = 0;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        backyard = new String[R];

        for (int i = 0; i < R; i++) {
            backyard[i] = br.readLine();
        }

        br.close();
    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void bfs(int r, int c) {
        int sheep = 0, wolf = 0;
        Deque<int[]> bfsQue = new ArrayDeque<>();

        bfsQue.addLast(new int[]{r, c});
        visited[r][c] = true;
        switch (backyard[r].charAt(c)) {
            case 'o':
                sheep++;
                break;
        
            case 'v':
                wolf++;
                break;
        }
        

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 경계 밖이면 버리기
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                // 방문 했으면 넘기기 or 울타리도 스킵
                if (visited[nr][nc] || backyard[nr].charAt(nc) == '#')  continue;

                // 방문처리하기
                bfsQue.addLast(new int[]{nr, nc});
                visited[nr][nc] = true;

                // 늑대랑 양 체크하기
                switch (backyard[nr].charAt(nc)) {
                    case 'o':
                        sheep++;
                        break;
                
                    case 'v':
                        wolf++;
                        break;
                }
            }
        }

        // 늑대와 양 생존 체크
        if (sheep > wolf) {
            Lsheep += sheep;
        } else {
            Lwolf += wolf;
        }
    }

    static void pro() {
        visited = new boolean[R][C];
        
        // 양과 염소 수 구하기
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c] && backyard[r].charAt(c) != '#') {
                    bfs(r, c);
                }
            }
        }

        System.out.println(Lsheep + " " + Lwolf);

        
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}