import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] time = new int[6];
        int[] ans = new int[3];

        try{
            for(int i = 0; i < 3; i++){
                time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                
                // 초 계산
                ans[2] = time[5] - time[2];

                if(ans[2] < 0){
                    ans[2] += 60;
                    time[4] -= 1;
                }

                // 분 계산
                ans[1] = time[4] - time[1];

                if(ans[1] < 0){
                    ans[1] += 60;
                    time[3] -= 1;
                }

                // 시 계산
                ans[0] = time[3] - time[0];

                bw.write(ans[0] + " " + ans[1] + " " + ans[2] + "\n");

            }
            bw.flush();
            bw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
