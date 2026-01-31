import java.io.*;
import java.util.*;

public class Main {
    static class Cell {
        boolean snake, apple;

        Cell() {
            this.snake = false;
            this.apple = false;
        }
    }

    static class Snake {
        int row, col;

        Snake(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, K, L;
    static Cell[][] map;
    static long time = 0L;
    static Map<Long, Character> rule = new HashMap<>();
    static Deque<Snake> snake = new ArrayDeque<>();
    
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 보드 생성
        N = Integer.parseInt(br.readLine());
        map = new Cell[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new Cell();
            }
        }

        // 사과 배치
        K = Integer.parseInt(br.readLine());
        int row, col;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map[row - 1][col - 1].apple = true;
        }

        // 방향변환 정보 저장
        L = Integer.parseInt(br.readLine());
        long t;
        String d;
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            t = Long.parseLong(st.nextToken());
            d = st.nextToken();

            rule.put(t, d.charAt(0));
        }
        
        br.close();
    }

    static void play() {
        // 초기 세팅
        // 뱀 설정
        snake.addLast(new Snake(0, 0));
        map[0][0].snake = true;

        // 회전관련 방향 배열
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        // 방향 인덱스
        int dirIdx = 0;

        // 뱀 이동 시작
        while (1 == 1) {
            // 시간 증가
            time++;

            // 새로 이동할 머리 위치 확인
            int nr = snake.peekLast().row + dr[dirIdx];
            int nc = snake.peekLast().col + dc[dirIdx];

            // 멈춤 조건(벽에 닿았거나 자기자신에게 닿았을 때)
            if ((nr < 0 || nc < 0 || nr >= N || nc >= N) || (map[nr][nc].snake)) {
                break;
            }

            // 머리이동 
            snake.addLast(new Snake(nr, nc));
            map[nr][nc].snake = true;

            // 사과 확인 + 꼬리 이동
            if (map[nr][nc].apple) {
                map[nr][nc].apple = false;
            } else {
                // 사라질 꼬리 위치
                Snake tail = snake.pollFirst();
                map[tail.row][tail.col].snake = false;
            }

            // 방향확인
            dirIdx = checkDir(dirIdx, time);
        }
    }

    static int checkDir(int idx, long time) {
        // 규칙에 없는 경우 원래 값 반환
        if (rule.get(time) == null) {
            return idx;
        }

        // 규칙이 있는 경우
        switch (rule.get(time)) {
            case 'D':
                return (idx + 1) % 4;
            case 'L':
                return (idx + 3) % 4;
        }

        // 에러방지용
        return 5;
    }

    
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.print(time);
         
    }
}