import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static int[] nums;
    static int[] cnt = new int[100000 + 1];

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    // 풀이
    static void pro() {
        int R = 0;
        long ans = 0;

        for (int L = 1; L <= N + 1; L++) {
            cnt[nums[L - 1]] = 0;

            while (R + 1 <= N && cnt[nums[R + 1]] == 0) {
                cnt[nums[++R]] = 1;
            }

            ans += R - L + 1;
        }

        System.out.println(ans);
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}