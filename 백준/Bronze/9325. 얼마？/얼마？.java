import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            int s, op, q, p;

            for(int i = 0; i< n; i++){
                int price = 0;
                price += Integer.parseInt(br.readLine());
                op = Integer.parseInt(br.readLine());
                for(int j = 0; j < op; j++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    q = Integer.parseInt(st.nextToken());
                    p = Integer.parseInt(st.nextToken());
                    price += q * p;
                }
                bw.write(String.valueOf(price));
                bw.newLine();
            }

            bw.flush();
            bw.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }




}