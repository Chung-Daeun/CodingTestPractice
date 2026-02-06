import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static int[] nums;

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(nums);
        br.close();
    }

    // 풀이
    static void pro() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int target = nums[i];
            int L = 0, R = N - 1;

            while (L < R) {
                // target이랑 같으면 L, R 이동
                if (i == L) {
                    L++;
                    continue;
                }

                if (i == R) {
                    R--;
                    continue;
                }

                int sum = nums[L] + nums[R];

                // 좋은 수 조건 달성
                if (sum == target) {
                    cnt++;
                    break;
                }

                // 달성 못한 경우
                if (sum > target) {
                    R--;
                } else {
                    L++;
                }

            }
        }

        System.out.println(cnt);
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}