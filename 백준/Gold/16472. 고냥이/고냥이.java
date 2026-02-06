import java.io.*;
import java.util.*;

public class Main{

    // 필요변수
    static int N;
    static String str;
    static int[] cnt = new int[26];

    // 입력
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();

        br.close();
    }

    // 풀이
    static void pro() {
        int len = str.length(), ans = 0, kind = 0;

        for (int R = 0, L = 0; R < len; R++) {
            // R번째 문자를 오른쪽에 추가
            char chR = str.charAt(R);
            cnt[chR - 'a']++;
            if (cnt[chR - 'a'] == 1)  kind++;

            // 불가능하면, 가능할 때까지 L을 이동
            while (kind > N) {
                char chL = str.charAt(L);
                cnt[chL - 'a']--;
                if (cnt[chL - 'a'] == 0)    kind--;
                L++;
            }

            // 정답 갱신
            ans = Math.max(ans, R - L + 1);
        }

        System.out.println(ans);
        
    }
    public static void main(String[] args) throws Exception{
        input();
        pro();
    }
}