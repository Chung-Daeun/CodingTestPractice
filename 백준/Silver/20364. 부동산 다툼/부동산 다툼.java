import java.io.*;
import java.util.*;

class Main {
    static int N, Q;
    static int[] arr;
    static boolean[] owned;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        owned = new boolean[N + 1];

        Q = Integer.parseInt(st.nextToken());
        arr = new int[Q];

        for (int i = 0; i < Q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }

    
    static void pro() {
        for (int num : arr) {

            int x = num;
            int blocked = 0;
            while (x > 0) {
                if (owned[x]) {
                    blocked = x;
                }
                x /= 2;
            }

            if (blocked == 0) {
                owned[num] = true;
            }

            sb.append(blocked).append("\n");
        }
    }

    

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        input();
        pro();
        System.out.println(sb.toString());
    }
}