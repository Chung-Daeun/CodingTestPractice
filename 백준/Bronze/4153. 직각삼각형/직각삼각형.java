import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static String rightTriangle(int[] inputInt) {
        Arrays.sort(inputInt);

        if (inputInt[0] * inputInt[0] + inputInt[1] * inputInt[1] == inputInt[2] * inputInt[2]) {
            return "right";
        }

        return "wrong";
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] inputInt = new int[3];
        // int[] inputInt = Arrays.stream(br.readLine().split(" "))
                                // .mapToInt(Integer::parseInt).toArray();

        while (1 == 1) {
            inputInt = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();

            if (Arrays.equals(inputInt, new int[]{0, 0, 0})){
                br.close();
                break;
            }

            bw.write(rightTriangle(inputInt) + "\n");
        }
        bw.flush();
        bw.close();
    }
}