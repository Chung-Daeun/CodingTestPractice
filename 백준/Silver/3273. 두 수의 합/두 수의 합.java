import java.io.*;
import java.util.*;

class Main {
    // 변수
    static int N, X;
    static int[] A;

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        X = Integer.parseInt(br.readLine());

        br.close();
    }

    // 풀이
    static void pro() {
        // 배열 정렬
        Arrays.sort(A);

        int left = 0, right = N - 1, cnt = 0;

        while (left < right) {
            int sum = A[left] + A[right];

            if (sum < X) {
                left++;
                continue;
            }

            if (sum > X) {
                right--;
                continue;
            }

            if (sum == X) {
                cnt++;
                left++;
            }
        }

        // 정답 출력
        System.out.println(cnt);
    }

    // 실행
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}