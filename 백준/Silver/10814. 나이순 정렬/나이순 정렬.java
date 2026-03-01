import java.io.*;
import java.util.*;

public class Main{
    // 회원정보 담을 자료형
    static class Member implements Comparable<Member>{
        int age;
        String name;

        @Override
        public int compareTo(Member other) {
            if (this.age != other.age) {
                return this.age - other.age;
            }

            return 0;
        }

    }

    // 필요변수
    static int N;
    static Member[] memList;

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 총 명수 입력
        N = Integer.parseInt(br.readLine());
        memList = new Member[N];

        for (int i = 0; i < N; i++) {
            // 줄 입력 후 쪼갬
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 배열에 객체 생성
            memList[i] = new Member();
            // 나이 저장
            memList[i].age = Integer.parseInt(st.nextToken());
            // 이름 저장
            memList[i].name = st.nextToken();
        }

        br.close();
    }

    // 풀이
    static void pro() {
        // 정렬
        Arrays.sort(memList);

        // 출력
        for (Member mem : memList) {
            System.out.print(mem.age + " " + mem.name + "\n");
        }
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}