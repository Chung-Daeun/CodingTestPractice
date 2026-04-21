import java.io.*;
import java.util.*;

class Main {
    static List<Integer>[] nodeList;
    static int N;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodeList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList[a].add(b);
            nodeList[b].add(a);
        }

        br.close();
    }

    static int ans = 0;
    static void dfs(int node, int parent, int depth) {
        boolean isLeaf = true;

        for (int nxt : nodeList[node]) {
            // 부모는 스킵
            if (nxt == parent)  continue;

            isLeaf = false;
            dfs(nxt, node, depth + 1);
        }

        if (isLeaf) {
            ans += depth;
        }
    }
    static void pro() {
        dfs(1, -1, 0);

        if (ans % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}