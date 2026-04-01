import java.io.*;
import java.util.*;

class Main {

    static int N, K;
    static int[] street = new int[100005];

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void bfs() {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 현재 위치 저장
        bfsQue.addLast(N);

        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            // 다음에 갈 수 있는 곳 구하기
            int[] nxt = new int[]{current - 1, current + 1, 2 * current};

            for (int num : nxt) {
                // 조건 밖은 무시
                if (num < 0 || num > 100000)    continue;
                
                // 시작점이 아니고 아직 안간본 곳만 체크
                if (num != N && street[num] == 0) {
                    bfsQue.addLast(num);
                    street[num] = street[current] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        input();
        bfs();
        System.out.println(street[K]);
    }
}