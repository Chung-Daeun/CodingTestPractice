import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.valueOf(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

            StringTokenizer st = null;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.valueOf(st.nextToken());

                if (a == 0) {
                    if (pq.isEmpty()){
                        bw.write("-1\n");
                    } else {
                        bw.write(pq.poll() + "\n");
                    }
                } else {
                    for (int j = 0; j < a; j++) {
                        pq.offer(Integer.valueOf(st.nextToken()));
                    }
                }
            }

            br.close();
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
