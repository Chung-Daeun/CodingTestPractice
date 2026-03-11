import java.io.*;
import java.util.*;

public class Main {
    // 변수
    static int N;
    static boolean[] visited;
    static List<Integer>[] nextNodeLists;
    static int[][] ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nextNodeLists = new List[N];
        for (int i = 0; i < N; i++) {
            nextNodeLists[i] = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    nextNodeLists[i].add(j);
                }
            }
        }

        br.close();
    }

    static void bfs(int num) {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 초기 값 넣기
        bfsQue.addLast(num);

        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            for (int i : nextNodeLists[current]) {
                // 이미 갈 수 있다고 판명난 곳은 스킵
                if (ans[num][i] == 0) {
                    ans[num][i] = 1;
                    bfsQue.addLast(i);
                }
            }
        }
    }

    static void pro() {
        ans = new int[N][N];
        // 경로 체크
        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        // 정답 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}