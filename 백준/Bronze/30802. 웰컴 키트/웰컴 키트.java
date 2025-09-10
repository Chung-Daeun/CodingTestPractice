import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static String tShirt(int group, int[] tSize) {
        int ans = 0;
        boolean isDiv;

        for (int t : tSize) {
            isDiv = t % group == 0;
            ans += t / group;

            if (!isDiv) {
                ans += 1;
            }
        }

        return String.valueOf(ans);
    }

    public static String pen(int people, int group) {
        String ans = "";
        ans += people / group + " " + people % group;
        return ans;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int people = Integer.parseInt(br.readLine());
        int[] sizeArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] groupArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        bw.write(tShirt(groupArr[0], sizeArr) + "\n");
        bw.write(pen(people, groupArr[1]));
        bw.flush();
        bw.close();
    }
}