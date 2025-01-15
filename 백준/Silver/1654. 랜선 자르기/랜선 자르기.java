import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static long[] arr;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            final int T = Integer.parseInt(st.nextToken());
            final int K = Integer.parseInt(st.nextToken());
            arr = new long[T];

            long max = 0;
            for (int i = 0; i < T; i++) {
                arr[i] = Integer.parseInt(br.readLine());

                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            br.close();

            bw.write(String.valueOf(binarySearch(T, K, 1L, max)));
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static long binarySearch(int t, int k, long min, long max) {

        if (min > max) {
            return 0;
        }

        long mid = (min + max) / 2;
        int sum = 0;

        for (int i = 0; i < t; i++) {
            sum += arr[i] / mid;
        }

        if (sum >= k) {
            return Math.max(binarySearch(t, k, mid + 1, max), mid);
        }

        return binarySearch(t, k, min, mid - 1);

    }
}
