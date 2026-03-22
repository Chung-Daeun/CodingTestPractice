import java.io.*;
import java.util.*;

class Main {
    static int n, p1, p2;
    static List<Integer>[] family;
    static int[] dist;
    
    

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        family = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            family[i] = new ArrayList<Integer>();
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            family[parent].add(child);
            family[child].add(parent);
        }

        br.close();
    }

    static void initDist() {
        dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = -1;
        }
    }

    static void bfs(int start) {
        // 사용할 큐 생성
        Deque<Integer> bfsQue = new ArrayDeque<>();

        // 시작점 넣고 표시하기
        bfsQue.addLast(start);
        dist[start] = 0;

        // 그래프순회하기
        while (!bfsQue.isEmpty()) {
            int current = bfsQue.pollFirst();

            for (int num : family[current]) {
                if (dist[num] == -1) {
                    bfsQue.addLast(num);
                    dist[num] = dist[current] + 1;
                }
            }
        }

    }
    
    public static void main(String[] args) throws Exception {
        input();
        initDist();
        bfs(p1);
        System.out.println(dist[p2]);

    }
}