import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringBuffer sb = new StringBuffer();
            String st;
            while((st = br.readLine()) != null){
                sb = new StringBuffer(st);

                if(sb == null)
                    break;

                bw.write(sb.toString());
                bw.newLine();
            }

            bw.flush();
            br.close();
            bw.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }




}