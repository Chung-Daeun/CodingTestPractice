import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int c = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for(int i = 0; i < c; i++){
                st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int[] arr = new int[n];
                int sum = 0;
                for(int j = 0; j < n; j++){
                    arr[j] = Integer.parseInt(st.nextToken());
                    sum += arr[j];
                }
                double avg = sum / n;

                int cnt = 0;
                for(int j = 0; j < n; j++){
                    if(arr[j] > avg){
                        cnt++;
                    }
                }
                bw.write(String.format("%.3f", (double)cnt / n * 100) + "%\n");
            }
            br.close();
            bw.flush();
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}