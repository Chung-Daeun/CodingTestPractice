import java.io.*;
import java.util.*;

class Main {
    static int N;
    static List<Integer>[] adjLists;
    static int[] ans;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        // 배열 크기 선언
        adjLists = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjLists[i] = new ArrayList<>();
        }

        ans = new int[N + 1];

        // 연결정보 저장하기
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjLists[a].add(b);
            adjLists[b].add(a);
        }

        br.close();
    }

    static void BFS() {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 부모노드부터 시작
        bfsQue.addLast(1);

        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            for (int num : adjLists[current]) {
                if (ans[num] == 0) {
                    ans[num] = current;
                    bfsQue.addLast(num);
                }
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        input();
        BFS();
        print();
    }
}