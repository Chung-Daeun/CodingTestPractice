import java.io.*;
import java.util.*;

public class Main {
    static int minInt = Integer.MAX_VALUE;
    static int maxInt = Integer.MIN_VALUE;

    static int K;
    static int[] arr = new int[11];
    static int[] oper = new int[4];

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        br.close();
    }

    static int calc(int oper, int num, int ans) {
        switch (oper) {
            // 덧셈
            case 0:
                return ans + num;
            // 뺄셈
            case 1:
                return ans - num;
            // 곱셈
            case 2:
                return ans * num;
            // 나눗셈
            case 3:
                if (ans < 0) {
                    return (-ans / num) * (-1);
                }
                return ans / num;
        }

        return 0;
    }

    static void rec_func(int k, int ans) {
        if (k == K) {
            // 최솟값 확인
            minInt = Math.min(ans, minInt);

            // 최댓값 확인
            maxInt = Math.max(ans, maxInt);

            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자가 없으면 다음 연산자 고르기
            if (oper[i] == 0) {
                continue;
            }

            // 연산자 하나 지우기
            oper[i]--;
            // 다음 연산하러 보내기
            rec_func(k + 1, calc(i, arr[k], ans));
            // 연산자 되돌리기
            oper[i]++;

        }
    }

    public static void main(String[] args) throws Exception{
        input();
        rec_func(1, arr[0]);
        System.out.println(maxInt);
        System.out.println(minInt);
        
    }
}