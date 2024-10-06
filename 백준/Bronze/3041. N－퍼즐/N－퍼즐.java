import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringBuffer sb;
            int cnt = 0;

            for(int i = 0; i < 4; i++){
                sb = new StringBuffer(br.readLine());
                for(int j = 0; j < 4; j++){

                    switch (sb.charAt(j)){
                        case 'A':
                            cnt += Math.abs(i - 0) + Math.abs(j - 0);
                            break;
                        case 'B':
                            cnt += Math.abs(i - 0) + Math.abs(j - 1);
                            break;
                        case 'C':
                            cnt += Math.abs(i - 0) + Math.abs(j - 2);
                            break;
                        case 'D':
                            cnt += Math.abs(i - 0) + Math.abs(j - 3);
                            break;
                        case 'E':
                            cnt += Math.abs(i - 1) + Math.abs(j - 0);
                            break;
                        case 'F':
                            cnt += Math.abs(i - 1) + Math.abs(j - 1);
                            break;
                        case 'G':
                            cnt += Math.abs(i - 1) + Math.abs(j - 2);
                            break;
                        case 'H':
                            cnt += Math.abs(i - 1) + Math.abs(j - 3);
                            break;
                        case 'I':
                            cnt += Math.abs(i - 2) + Math.abs(j - 0);
                            break;
                        case 'J':
                            cnt += Math.abs(i - 2) + Math.abs(j - 1);
                            break;
                        case 'K':
                            cnt += Math.abs(i - 2) + Math.abs(j - 2);
                            break;
                        case 'L':
                            cnt += Math.abs(i - 2) + Math.abs(j - 3);
                            break;
                        case 'M':
                            cnt += Math.abs(i - 3) + Math.abs(j - 0);
                            break;
                        case 'N':
                            cnt += Math.abs(i - 3) + Math.abs(j - 1);
                            break;
                        case 'O':
                            cnt += Math.abs(i - 3) + Math.abs(j - 2);
                            break;
                    }
                }
            }

            br.close();
            bw.write(String.valueOf(cnt));
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}