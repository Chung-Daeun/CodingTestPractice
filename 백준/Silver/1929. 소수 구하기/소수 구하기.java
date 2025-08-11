import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static String primaryNum(int m, int n) {
        String ans = "";
        boolean isPrime = false;

        for (int i = m; i <= n; i++) {
            isPrime = true;

            if (i == 1) {
                continue;
            }

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                ans += i + "\n";
            }
        }

        return ans;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputInt = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt).toArray();
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(primaryNum(inputInt[0], inputInt[1]));
        bw.flush();
        bw.close();
    }
}