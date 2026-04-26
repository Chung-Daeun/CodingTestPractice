import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] parents;
    static int x, y, depX, depY;
    static List<Integer> xList = new ArrayList<>();
    
    static void input() throws Exception {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            parents[b] = a;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
    }

    static StringBuilder sb = new StringBuilder();
    static void pro(int x, int y) {
        if (x == y) {
            sb.append(x).append("\n");
            return;
        }

        pro(parents[x], parents[y]);
    }

    static int searchDepth(int x) {
        int num = 0;
        while (parents[x] != 0) {
            num++;
            x = parents[x];
        }

        return num;
    }

    static void sameDep() {
        if (depX > depY) {
            while (depX != depY) {
                depX--;
                x = parents[x];
            }
        }

        if (depX < depY) {
            while (depX != depY) {
                depY--;
                y = parents[y];
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();
            depX = searchDepth(x);
            depY = searchDepth(y);
            sameDep();
            pro(x, y);
        }
        System.out.println(sb.toString());
        
    }
}