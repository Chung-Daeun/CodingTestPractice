import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static int K;
    static int[] A;

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 저장
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 선언
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        // 배열 값 저장
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        br.close();
    }

    // 풀이
    static void pro() {
        int sum = 0;
        int left = 0, right = 0;

        // 첫 K개 합 구하기
        for (; right < K; right++) {
            sum += A[right];
        }
        // 정답값 선언
        int maxSum = sum;

        // left는 제거하고 right는 더하기
        while (right < N) {
            sum -= A[left++];
            sum += A[right++];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}