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
            StringBuilder words[] = new StringBuilder[5];
            int len = 0;

            for(int i = 0; i < 5; i++){
                words[i] = new StringBuilder(br.readLine());
                len = Math.max(len, words[i].length());
            }

            br.close();

            String ans = "";

            for(int i = 0; i < len; i++){
                for(int j = 0; j < 5; j++){
                    if(words[j].length() > i){
                        ans += words[j].charAt(i);
                    }
                }
            }

            bw.write(ans);
            bw.flush();
            bw.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}