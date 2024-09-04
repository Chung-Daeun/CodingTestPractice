import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            br.close();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i <= j) {
                        bw.write("*");
                    } else {
                        bw.write(" ");
                    }
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}