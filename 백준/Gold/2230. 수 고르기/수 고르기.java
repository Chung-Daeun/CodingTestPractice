import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N, M;
    static int[] A;

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }

    // 풀이
    static void pro() {
        // 배열 정렬
        Arrays.sort(A);

        int result = A[N - 1] - A[0];

        int left = 0, right = 0;

        while (left < N && right < N && left <= right) {
            int sub = A[right] - A[left];

            if (sub < M) {
                right++;
            } else {
                result = Math.min(result, sub);
                left++;
            }
        }

        System.out.println(result);
    }

    // 실행
    public static void main(String[] args) throws Exception {
        input();
        pro();
        
    }
}