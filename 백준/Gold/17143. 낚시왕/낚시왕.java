import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    
    private static class Shark {
        int r, c;
        int s;  // 속력
        int d;  // 이동방향(1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽)
        int z;  // 크기

        // 낚시하기
        static void fishing(int c) {
            for (int r = 1; r <= R; r++) {
                if (sea[r][c] != null) {
                    fishes += sea[r][c].z;
                    sea[r][c] = null;
                    break;
                }
            }
        }

        // 상어 이동
        private static void moveShark() {
            Shark[][] nxt = new Shark[105][105];

            for (int r = 1; r <= R; r++) {
                for (int c = 1; c <= C; c++) {
                    if (sea[r][c] != null) {
                        Shark shark = new Shark();
                        
                        switch(sea[r][c].d) {
                            // 세로 이동
                            case 1: case 2:
                                shark = changeRow(sea[r][c]);
                                break;
                            // 가로 이동
                            case 3: case 4:
                                shark = changeColumn(sea[r][c]);
                                break;
                        }

                        // 같은 위치에 이미 상어 있는지 확인
                        if (eatShark(nxt[shark.r][shark.c], shark.z)) 
                            nxt[shark.r][shark.c] = shark;
                    }
                }
            }
            // 새로운 위치로 업데이트
            sea = nxt;
        }

        // 상어 잡아먹기
        private static boolean eatShark(Shark shark, int size) {
            // 비었으면 자리를 차지하도록
            if (shark == null)  return true;

            return shark.z < size;
        }

        // 세로 이동
        private static Shark changeRow(Shark shark) {
            int move = shark.s % (2 * (R - 1));

            // 이동
            while (move-- > 0) {
                // 맨 위에 도착하면 아래로 내려가기
                if (shark.r == 1 && shark.d == 1) shark.d = 2;
                // 맨 아래 도착하면 위로 올라가기
                if (shark.r == R && shark.d == 2) shark.d = 1;

                // 이동
                shark.r += (shark.d == 1 ? -1 : 1);
            }

            return shark;
        }

        // 가로 이동
        private static Shark changeColumn(Shark shark) {
            int move = shark.s % (2 * (C - 1));

            // 이동
            while (move-- > 0) {
                // 맨 위에 도착하면 아래로 내려가기
                if (shark.c == 1 && shark.d == 4) shark.d = 3;
                // 맨 아래 도착하면 위로 올라가기
                if (shark.c == C && shark.d == 3) shark.d = 4;

                // 이동
                shark.c += (shark.d == 4 ? -1 : 1);

            }

            return shark;
        }
    }

    // 변수 선언
    private static int R, C, M;
    private static Shark[][] sea = new Shark[105][105];
    private static int fishes = 0;
    

    public static void main(String[] args) throws Exception {
        // 입력
        input();

        // 실행
        pro();

        // 출력
        print();
        
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int r, c;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            sea[r][c] = new Shark();
            sea[r][c].r = r;
            sea[r][c].c = c;
            sea[r][c].s = Integer.parseInt(st.nextToken());
            sea[r][c].d = Integer.parseInt(st.nextToken());
            sea[r][c].z = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    private static void pro() {
        for (int fisher = 1; fisher <= C; fisher++) {
            // 상어 잡기
            Shark.fishing(fisher);

            // 마지막 줄이면 낚시 완료
            if (fisher == C)    break;

            // 상어 이동
            Shark.moveShark();
        }
    }

    private static void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(fishes + " ");
        bw.flush();
        bw.close();
    }
}