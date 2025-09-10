import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int problem = Integer.parseInt(br.readLine());
        br.close();

        int num = (int)Math.log10(problem);
        boolean isAnswer = false;
        int temp = 0;

        for (int i = problem - 9 * (num + 1); i <= problem; i++) {
            isAnswer = false;
            temp = i;

            for (int j = num; j >= 0; j--) {
                temp += i % (int)Math.pow(10, j + 1) / (int)Math.pow(10, j);
            }

            if (temp == problem) {
                isAnswer = true;
                bw.write(String.valueOf(i));
                break;
            }
        }

        if (!isAnswer) {
            bw.write("0");
        }

        bw.flush();
        bw.close();
    }
}