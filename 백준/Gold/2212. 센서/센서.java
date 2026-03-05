import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] sensors;

    // 입력
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 센서, 집중국 수 저장
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 센서 위치 저장
        sensors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        br.close();
    }

    /*
    센서들을 줄세운 후 집중국 수만큼 그룹핑을 해서 담당 집중국을 배정한다고 생각하자
    그러면 그룹과 그룹 사이의 거리는 집중국이 담당하지 않아도 된다.
    아 그러면 센서랑 센서 사이가 먼 순서대로 잘라버리면 되겠구나!
    */
     
    static void pro() {
        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 센서 별 거리 구하기
        int[] distances = new int[N - 1];
        for (int i = 1; i < N; i++) {
            distances[i - 1] = sensors[i] - sensors[i - 1];
        }
        // 거리 정렬
        Arrays.sort(distances);

        // 최대 거리 구하기
        int result = sensors[N - 1] - sensors[0];
        // 가장 먼 거리부터 끊어내기
        for (int i = 0; i < Math.min(K - 1, N - 1); i++) {  // 집중국의 수가 센서보다 많은게 문제 조건 상 가능함.
            result -= distances[N - 2 - i];
        }

        // K >= N 이면 당연히 result가 0으로 나오겠지?
        System.out.println(result);

    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
        
    }
}