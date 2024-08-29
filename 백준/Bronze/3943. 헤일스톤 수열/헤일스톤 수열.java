import java.io.*;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());

            int a;
            for(int i = 0; i < n; i++){
                a = Integer.parseInt(br.readLine());
                int max = a;
                while(a != 1){
                    if(a % 2 == 0){
                        a /= 2;
                    } else {
                        a *= 3;
                        a += 1;
                    }

                    if(a > max){
                        max = a;
                    }
                }

                bw.write(String.valueOf(max));
                bw.newLine();
                bw.flush();
            }

            br.close();
            bw.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}