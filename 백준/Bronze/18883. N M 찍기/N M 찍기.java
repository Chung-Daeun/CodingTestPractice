import java.io.*;
import java.util.*;

class Main {
    
    static int N, M;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        br.close();
    }

    static void pro() {
        StringBuilder sb = new StringBuilder();

        int num = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(num++);
                if (j != M) {
                    sb.append(" ");
                }
            }
            if (i != N) {
                sb.append("\n");
            }
        }

        System.out.println(sb);

    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}