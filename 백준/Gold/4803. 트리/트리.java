import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Integer>[] adjLists;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static boolean input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 마지막인지 아닌지 확인
        if (N == 0 && M == 0)   return false;

        // 인접리스트 배열 크기 선언
        adjLists = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjLists[i] = new ArrayList<>();
        }

        // 방문체크 배열 크기 선언
        visited = new boolean[N + 1];

        // 연결정보 저장하기
        for (int i = 0; i < M; i++) {
            // 입력
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            // 저장
            adjLists[n1].add(n2);
            adjLists[n2].add(n1);
        }

        return true;
    }

    static void pro(int caseNum) {
        sb.append("Case ").append(caseNum).append(": ");

        // 트리갯수 세팅
        int trees = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (dfs(i, 0)) {
                    trees++;
                }
            }
        }

        switch (trees) {
            case 0:
                sb.append("No trees.");
                break;
            
            case 1:
                sb.append("There is one tree.");
                break;
        
            default:
                sb.append("A forest of ").append(trees).append(" trees.");
                break;
        }

        sb.append("\n");
    }

    static boolean dfs(int num, int parent) {
        if (visited[num])   return false;

        visited[num] = true;

        for (int n : adjLists[num]) {
            if (n == parent)    continue;
            if (!dfs(n, num))   return false;
        }

        return true;
    }
    

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int t = 0;
        while (input()) {
            pro(++t);
        }

        br.close();

        System.out.println(sb.toString());
    }
}