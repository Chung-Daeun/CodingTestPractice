import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int num = Integer.valueOf(br.readLine());

            for (int i = 0; i < num; i++) {
                String[] str = br.readLine().split(" ");
                bw.write("Case #" + (i + 1) + ": ");
                for (int j = str.length - 1; j >= 0; j--) {
                    bw.write(str[j] + " ");
                }
                bw.write("\n");
            }

            br.close();
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
