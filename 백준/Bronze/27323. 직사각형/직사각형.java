import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            br.close();

            bw.write(String.valueOf(x * y));
            bw.flush();
            bw.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }

    


}