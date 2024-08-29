import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringBuffer sb = new StringBuffer();
            boolean is_print = false;

            while(true){
                sb = new StringBuffer(br.readLine());

                if(sb.toString().equals("0")){
                    break;
                }

                for(int i = 0; i <= sb.length() / 2; i++){
                    if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){
                        bw.write("no\n");
                        is_print = true;
                        break;
                    }
                }

                if(!is_print)
                    bw.write("yes\n");

                is_print = false;
            }

            bw.flush();
            bw.close();
            br.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }


}