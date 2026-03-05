import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] A, B;
    static StringBuilder sb = new StringBuilder();

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 저장
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();
    }
     
    static void pro() {
        // 각 배열 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 각 배열 비교하며 출력하기
        int idxA = 0, idxB = 0;

        while (idxA < N && idxB < M) {
            if (A[idxA] <= B[idxB]) {
                addNumber(A[idxA]);
                idxA++;
            } else {
                addNumber(B[idxB]);
                idxB++;
            }
        }

        // 비교 후 남은 애들 붙이기
        for (; idxA < N; idxA++) {
            addNumber(A[idxA]);
        }
        for (; idxB < M; idxB++) {
            addNumber(B[idxB]);
        }

        System.out.println(sb.toString());

    }

    // 답 만들기
    static void addNumber(int num) {
        sb.append(num).append(" ");
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
        
    }
}