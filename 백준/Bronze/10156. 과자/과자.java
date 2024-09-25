import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            br.close();

            int ans = k * n - m;

            if(ans < 0){
                ans = 0;
            }
            bw.write(String.valueOf(ans));
            bw.flush();
            bw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}