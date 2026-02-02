import java.io.*;
import java.util.*;

public class Main{

    static int N, S;
    static int[] nums;
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 수열 입력 받기
        st = new StringTokenizer(br.readLine());
        nums = new int[N + 1];
        for (int i = 1; i <= N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static void pro() {
        int r = 0, sum = 0, ans = N + 1;
        for (int l = 1; l <= N; l++) {
            // L - 1을 구간에서 제외하기
            sum -= nums[l - 1];

            // R을 옮길 수 잇을 때 까지 옮기기
            while (r + 1 <= N && sum < S) {
                sum += nums[r + 1];
                r++;
            }

            // [L...R]의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if (sum >= S) {
                ans = Math.min(ans, r - l + 1);
            }
        }

        // ans 값을 보고 불가능 판단하기
        if (ans == N + 1) {
            ans = 0;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}