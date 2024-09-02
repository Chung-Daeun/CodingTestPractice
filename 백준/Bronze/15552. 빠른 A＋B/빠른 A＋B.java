import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st;

            int a, b;

            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                bw.write((a + b) + "\n");
            }

            bw.flush();
            bw.close();
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}