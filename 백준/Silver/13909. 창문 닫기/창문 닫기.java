import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int n = Integer.parseInt(br.readLine());
            br.close();

            bw.write(String.valueOf((int)Math.sqrt(n)));
            bw.flush();
            bw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}