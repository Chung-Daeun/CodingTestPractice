import java.io.*;
import java.util.*;

public class Main {
    // 변수
    static int node, edge;
    static List<Integer>[] networkLists;
    static boolean[] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        networkLists = new List[node + 1];
        for (int i = 0; i <= node; i++) {
            networkLists[i] = new ArrayList<>();
        }
 
        for (int i = 0; i < edge; i++) {
            int[] spots = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            networkLists[spots[0]].add(spots[1]);
            networkLists[spots[1]].add(spots[0]);
        }

        visited = new boolean[node + 1];

        br.close();
    }

    static void pro() {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 초기값 추가
        bfsQue.addLast(1);
        visited[1] = true;
        int cnt = 0;

        while (!bfsQue.isEmpty()) {
            // 꺼내기
            int current = bfsQue.pollFirst();

            // 연결된 모든 컴퓨터 조사
            for (int num : networkLists[current]) {
                // 방문 전이라면
                if (!visited[num]) {
                    // 큐에 추가
                    bfsQue.addLast(num);
                    // 방문처리
                    visited[num] = true;
                    // 감염수 추가
                    cnt++;
                }
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