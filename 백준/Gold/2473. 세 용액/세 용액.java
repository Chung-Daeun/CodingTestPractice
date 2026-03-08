import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N;
    static long[] A;

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        br.close();
    }

    // 풀이
    static void pro() {
        // 배열 정렬
        Arrays.sort(A);

        long bestSum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;

        for (int cand = 0; cand < N - 2; cand++) {
            int left = cand + 1, right = N - 1;

            while (left < right) {
                long sum = A[cand] + A[left] + A[right];

                // 최적값이 나오면 변경
                if (bestSum > Math.abs(sum)) {
                    bestSum = Math.abs(sum);
                    v1 = cand;
                    v2 = left;
                    v3 = right;
                }

                if (sum > 0) {
                    right--;
                    continue;
                }

                if (sum < 0) {
                    left++;
                    continue;
                }

                if (sum == 0) {
                    break;
                }
            }

        }

        // 정답 출력
        System.out.println(A[v1] + " " + A[v2] + " " + A[v3]);
    }

    // 실행
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}