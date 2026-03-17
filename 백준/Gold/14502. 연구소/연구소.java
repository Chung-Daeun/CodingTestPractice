import java.io.*;
import java.util.*;

class Main {
    
    static int R, C;
    static int[][] map;
    static List<int[]> virusList = new ArrayList<>(), blankList = new ArrayList<>();
    static boolean[][] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연구소 크기 저장
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 칸 내용 저장
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스칸은 바이러스 리스트에 위치 저장
                if (map[i][j] == 2) {
                    virusList.add(new int[]{i, j});
                }
                // 빈칸은 빈칸 리스트에 위치 저장
                if (map[i][j] == 0) {
                    blankList.add(new int[]{i, j});
                }
            }
        }

        br.close();
    }

    static void buildWall(int idx, int isSelected) {
        // 세개 다 골랐을 경우
        if (isSelected == 3) {
            spreadVirus();
            return;
        }

        // idx가 경계 밖으로 넘어간 경우
        if (idx >= blankList.size())    return;

        // 선택할 경우
        map[blankList.get(idx)[0]][blankList.get(idx)[1]] = 1;
        buildWall(idx + 1, isSelected + 1);

        // 선택 안할 경우
        map[blankList.get(idx)[0]][blankList.get(idx)[1]] = 0;
        buildWall(idx + 1, isSelected);
    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static void spreadVirus() {
        visited = new boolean[R][C];

        Deque<int[]> bfsQue = new ArrayDeque<>();

        // 초기값 넣기
        for (int[] spot : virusList) {
            bfsQue.addLast(spot);
            visited[spot[0]][spot[1]] = true;
        }

        while (!bfsQue.isEmpty()) {
            int[] current = bfsQue.pollFirst();

            // 상하좌우 퍼트리기
            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dir[i][0];
                int nc = current[1] + dir[i][1];

                // 경계 밖 스킵
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                // 아직 방문하지 않은 빈칸 추가
                if (!visited[nr][nc] && map[nr][nc] == 0) {
                    bfsQue.addLast(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        countBlank();
    }

    static int maxCount = -1;
    static void countBlank() {
        int cnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // 방문하지 않은 빈칸(오염안된 칸) 숫자 세기
                if (map[r][c] == 0 && !visited[r][c]) {
                    cnt++;
                }
            }
        }

        maxCount = Math.max(maxCount, cnt);
    }

    static void pro() {
        buildWall(0, 0);
        System.out.println(maxCount);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}