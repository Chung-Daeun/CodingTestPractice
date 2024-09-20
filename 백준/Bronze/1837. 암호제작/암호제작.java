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
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger p = new BigInteger(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            br.close();

            boolean isWrite = false;

            for(long i = 2; i < k; i++){
                boolean isPrime = true;
                for(long j = 2; j <= Math.sqrt(i); j++){
                    if(i != j && i % j == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    if(p.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)){
                        bw.write("BAD " + BigInteger.valueOf(i).min(p.divide(BigInteger.valueOf(i))));
                        isWrite = true;
                        break;
                    }
                }
            }

            if(!isWrite){
                bw.write("GOOD");
            }

            bw.flush();
            bw.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}