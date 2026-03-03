import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static long M;
    static int[] A;

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 저장
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

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
        long sum = 0;
        int right = 0, cnt = 0;

        for (int left = 0; left < N; left++) {
            // M 또는 M보다 커질 때까지 더하기
            while (sum < M && right < N) {
                sum += A[right++];
            }

            // M과 같은지 체크
            if (sum == M)   cnt++;
            
            // left를 합에서 빼기
            sum -= A[left];
        }

        System.out.println(cnt);
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}