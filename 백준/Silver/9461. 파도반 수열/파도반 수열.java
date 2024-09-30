import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long padovan[] = new long[100];

        padovan[0] = padovan[1] = padovan[2] = 1;
        padovan[3] = padovan[4] = 2;

        for(int i = 5; i < 100; i++){
            padovan[i] = padovan[i - 1] + padovan[i - 5];
        }

        try{
            int t = Integer.parseInt(br.readLine());
            for(int i = 0; i < t; i++){
                int n = Integer.parseInt(br.readLine());
                bw.write(padovan[n - 1] + "\n");
            }
            bw.flush();
            bw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}