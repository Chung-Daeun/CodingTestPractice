import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> nums = new ArrayList<>();

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기 저장
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 값 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        br.close();
    }
     
    static void pro() {
        // 값을 하나의 리스트에 넣고 정렬시켜버리기
        Collections.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(nums.get(i)).append(" ");
        }

        System.out.println(sb.toString());

    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
        
    }
}