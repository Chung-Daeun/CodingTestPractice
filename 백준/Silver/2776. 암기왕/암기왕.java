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
            int T = Integer.parseInt(br.readLine());
            Boolean isReal = false;

            while (T != 0) {
                int n = Integer.parseInt(br.readLine());
                int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
                int m = Integer.parseInt(br.readLine());
                int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int i = 0; i < m; i++) {
                    int result = Arrays.binarySearch(arr1, arr2[i]);
                    if (result >= 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                }

                T--;
            }

            bw.flush();
            br.close();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
