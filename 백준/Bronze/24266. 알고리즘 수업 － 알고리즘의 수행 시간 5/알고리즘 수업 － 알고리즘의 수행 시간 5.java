import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            long x = Long.parseLong(br.readLine());

            br.close();

            bw.write(String.valueOf(x * x * x));
            bw.newLine();
            bw.write(String.valueOf(3));
            bw.flush();
            bw.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }




}