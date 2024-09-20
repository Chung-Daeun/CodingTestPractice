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
            int m = Integer.parseInt(br.readLine());
            int[] arr = {1, 2, 3};

            for(int i = 0; i < m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int i_x = 0;
                int i_y = 0;
                for(int j = 0; j < 3; j++){
                    if(arr[j] == x){
                        i_x = j;
                    }
                    if(arr[j] == y){
                        i_y = j;
                    }
                }

                arr[i_x] = y;
                arr[i_y] = x;
//                System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
            }

            br.close();

            bw.write(String.valueOf(arr[0]));
            bw.flush();
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}