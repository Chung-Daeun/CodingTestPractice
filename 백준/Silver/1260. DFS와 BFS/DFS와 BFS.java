import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N, M, V;
    static List<List<Integer>> nodeList = new ArrayList<>();

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 그래프 틀잡기
        for (int i = 0; i < N + 5; i++) {
            nodeList.add(new ArrayList<Integer>());
        }

        // 정점 적용하기
        int[] line = new int[2];
        for (int i = 0; i < M; i++) {
            // 양 끝 점 입력받기
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 양쪽에 저장
            nodeList.get(line[0]).add(line[1]);
            nodeList.get(line[1]).add(line[0]);
        }

        // 정점 정렬
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(nodeList.get(i));
        }

        br.close();
    }

    static void dfs() {
        Deque<Integer> dfsStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[N + 1];

        // 시작
        dfsStack.addLast(V);

        while (!dfsStack.isEmpty()) {
            // 방문할 노드 추출
            int nowNode = dfsStack.pollLast();

            // 방문가능한지 체크
            if (visited[nowNode] == 0) {
                // 가능
                // 방문 함을 표시
                visited[nowNode] = 1;
                // 답안에 추가
                sb.append(nowNode).append(" ");

                // 연결된 노드 추가
                int conSize = nodeList.get(nowNode).size();
                for (int i = 0; i < conSize; i++) {
                    dfsStack.addLast(nodeList.get(nowNode).get(conSize - 1 - i));
                }
            }   // 불가능은 스킵

        }

        // 출력
        System.out.println(sb.toString());

    }

    static void bfs() {
        Deque<Integer> bfsQue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] visited = new int[N + 1];

        // 시작점 추가
        bfsQue.addLast(V);
        
        while (!bfsQue.isEmpty()) {
            int nowNode = bfsQue.pollFirst();

            // 방문 가능한지 체크
            if (visited[nowNode] == 0) {
                // 가능
                visited[nowNode] = 1;
                sb.append(nowNode).append(" ");

                // 연결된 노드 추가
                for (int i = 0; i < nodeList.get(nowNode).size(); i++) {
                    bfsQue.addLast(nodeList.get(nowNode).get(i));
                }
            }   // 불가능은 스킵
        }

        System.out.println(sb.toString());
    }

    // 실행
    public static void main(String[] args) throws Exception {
        input();
        dfs();
        bfs();
    }
}