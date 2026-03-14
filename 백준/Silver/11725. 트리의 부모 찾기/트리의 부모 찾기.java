import java.io.*;
import java.util.*;

class Main {
    
    static int N;
    static List<Integer>[] tree;
    static int[] parents;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        br.close();
    }

    static void bfs() {
        Deque<Integer> bfsQue = new ArrayDeque<>();

        bfsQue.addLast(1);
        parents[1] = -1;

        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            for (int num : tree[current]) {
                // 부모가 없는 노드만 부모 추가
                if (parents[num] == 0) {
                    parents[num] = current;
                    bfsQue.addLast(num);
                }
            }
        }
    }

    static void pro() {
        parents = new int[N + 1];
        bfs();

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }

        
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}