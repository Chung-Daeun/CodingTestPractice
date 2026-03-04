import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N, K;
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
        int len = Integer.MAX_VALUE, cnt = 0;

        // left부터 right가 확인할 인형 집합
        for (int left = 0, right = 0; left < N; left++) {
            // 조건에 맞게 right 키우기(주어진 인형 밖으로 갈 수는 없다.)
            while (cnt < K && right < N) {
                // 라이언 발견시 cnt 추가
                if (A[right++] == 1)  ++cnt;  
            }

            // 조건에 맞다면 값 비교
            if (cnt == K) {
                len = Math.min(len, right - left);
            }

            // 다음 자리부터 검증하기 위해 현재자리 빼두기
            if (A[left] == 1)   --cnt;
        }

        // 출력
        if (len == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(len);
        }

    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}