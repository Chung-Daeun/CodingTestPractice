import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i++){
                int num = Integer.parseInt(st.nextToken());
                if(!is_nonprimeNumber(num)){
                    cnt++;
                }

//                bw.write("num:" + num + "\n");
//                bw.write("cnt:" + cnt + "\n");
//                bw.flush();
            }

            bw.write(String.valueOf(cnt));
            bw.flush();
            bw.close();
            br.close();

        } catch(IOException io) {
            io.printStackTrace();
        }


    }

    public static boolean is_nonprimeNumber(int num){
        boolean[] primeNumber = new boolean[1000];

        primeNumber[0] = true;

        for(int i = 1; i < 1000; i++){
            if(!primeNumber[i]){
                for(int j = 2 * i + 1; j < 1000; j += (i + 1)){
                    primeNumber[j] = true;
                }
            }
        }

        return primeNumber[num - 1];
    }
}