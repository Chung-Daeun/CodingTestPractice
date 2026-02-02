import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static int[] liq;
    static StringBuilder sb = new StringBuilder();

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        liq = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(liq);

        br.close();
    }

    // 풀이
    static void pro() {
        int best_sum = Integer.MAX_VALUE;

        int v1 = 0, v2 = 0, L = 0, R = N - 1;

        while (L < R) {
            int curr_sum = liq[L] + liq[R];

            // 최적합 교체
            if (Math.abs(curr_sum) < Math.abs(best_sum)){
                best_sum = curr_sum;
                v1 = liq[L];
                v2 = liq[R];
            }

            // L교체 여부
            if (curr_sum < 0) {
                L++;
            } 

            // R교체 여부
            if (curr_sum > 0) {
                R--;
            }

            // 0이면 너무 좋으니 그만 보자
            if (curr_sum == 0) {
                break;
            }

        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}