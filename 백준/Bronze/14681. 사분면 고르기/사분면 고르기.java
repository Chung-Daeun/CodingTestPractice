import java.io.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            br.close();

            bw.write(String.valueOf(quadrant(x, y)));
            bw.flush();
            bw.close();

        } catch(IOException io){
            io.printStackTrace();
        }

    }

    public static int quadrant(int x, int y){

        if(x > 0 && y > 0){
            return 1;
        }

        if(x < 0 && y > 0){
            return 2;
        }

        if(x < 0 && y < 0){
            return 3;
        }

        if(x > 0 && y < 0){
            return 4;
        }

        return 0;
    }


}