import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[][] adjArr;
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        // 배열 크기 선언
        adjArr = new char[N][2];

        // 연결정보 저장하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            adjArr[idx][0] = st.nextToken().charAt(0);
            adjArr[idx][1] = st.nextToken().charAt(0);
        }

        br.close();
    }

    static void preOrder(char curr) {
        // 종료조건
        if (curr == '.')    return;

        // 루트
        sb.append(curr);
        // 왼쪽자식
        preOrder(adjArr[curr - 'A'][0]);
        // 오른쪽 자식
        preOrder(adjArr[curr - 'A'][1]);     
    }

    static void inOrder(char curr) {
        // 종료조건
        if (curr == '.')    return;

        // 왼쪽자식
        inOrder(adjArr[curr - 'A'][0]);
        // 루트
        sb.append(curr);
        // 오른쪽 자식
        inOrder(adjArr[curr - 'A'][1]);     
    }

    static void postOrder(char curr) {
        // 종료조건
        if (curr == '.')    return;
        
        // 왼쪽자식
        postOrder(adjArr[curr - 'A'][0]);
        // 오른쪽 자식
        postOrder(adjArr[curr - 'A'][1]);     
        // 루트
        sb.append(curr);
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        input();

        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
        sb.append("\n");

        System.out.println(sb.toString());
    }
}