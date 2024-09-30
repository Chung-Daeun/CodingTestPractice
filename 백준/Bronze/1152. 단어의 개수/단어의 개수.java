import java.io.*;

public class Main {
    public static void main(String[] args) {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        try{
           String words[] = br.readLine().trim().split(" ");
           br.close();
           
           if(words[0].equals("")){
               bw.write("0");
           } else{
             bw.write(String.valueOf(words.length));  
           }
            
           bw.flush();
           bw.close();
        }catch(Exception e){
            e.printStackTrace();
        }
           
        
    }
}
