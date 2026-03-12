import java.io.*;
import java.util.*;

class Main {
    // 물통 상태 관리
    static class State {
        int[] X;

        State(int[] _X) {
            X = new int[3];
            for (int i = 0; i < 3; i++) {
                X[i] = _X[i];
            }
        }

        State move(int from, int to) {
            // from 물통에서 to 물통으로 물을 옮긴다.
            int[] nX = new int[]{X[0], X[1], X[2]};

            if (nX[from] + nX[to] <= Limits[to]) {
                nX[to] += nX[from];
                nX[from] = 0;
            } else {
                nX[from] -= Limits[to] - nX[to];
                nX[to] = Limits[to];
            }

            return new State(nX);
        }
    }

    // 필요변수
    static int[] Limits;
    static boolean[] possible;
    static boolean[][][] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Limits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        possible = new boolean[Limits[2] + 5];
        visited = new boolean[Limits[0] + 5][Limits[1] + 5][Limits[2] + 5];

        br.close();
    }

    static void bfs(int a, int b, int c) {
        Deque<State> bfsQue = new ArrayDeque<>();

        bfsQue.addLast(new State(new int[]{a, b, c}));
        visited[a][b][c] = true;

        while (!bfsQue.isEmpty()) {
            State current = bfsQue.pollFirst();
            if (current.X[0] == 0) {
                possible[current.X[2]] = true;
            }

            // 물 옮기기
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 출발지랑 목적지가 같으면 skip
                    if (i == j) continue;

                    // 옮긴 결과
                    State next = current.move(i, j);

                    // 이전에 만났던 경우인지 확인, 아니라면 Que에 넣기
                    if (!visited[next.X[0]][next.X[1]][next.X[2]]) {
                        bfsQue.addLast(next);
                        visited[next.X[0]][next.X[1]][next.X[2]] = true;
                    }

                }
            }
        }
    }

    static void pro() {
        bfs(0, 0, Limits[2]);

        // 정답 출력
        for (int i = 0; i < possible.length; i++) {
            if (possible[i]) {
                System.out.print(i + " ");
            }
        }

    }
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}