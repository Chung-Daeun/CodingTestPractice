import java.io.*;
import java.util.*;

public class Main {
    // 변수
    static int N, M;
    static List<Integer>[] graphLists;
    static boolean[] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int u, v;
        graphLists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graphLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            graphLists[u].add(v);
            graphLists[v].add(u);
        }
        
        visited = new boolean[N + 1];

        br.close();
    }

    static void bfs(int n) {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 시작점 추가
        bfsQue.addLast(n);

        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            // current와 연결된 점들 확인
            for (int num : graphLists[current]) {
                // 방문전이면 추가
                if (!visited[num]) {
                    bfsQue.addLast(num);
                    // 방문 표시
                    visited[num] = true;
                }
            }
        }
    }

    static void pro() {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                visited[i] = true;
                bfs(i);
            }
        }

        // 정답 출력
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}