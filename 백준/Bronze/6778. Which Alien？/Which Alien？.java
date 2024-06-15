import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alien = new String[3];
        int antenna = sc.nextInt();
        int eyes = sc.nextInt();
        int idx = 0;
        if(antenna >= 3 && eyes <= 4){
            alien[idx++] = "TroyMartian";
        }
        if(antenna <= 6 && eyes >= 2){
            alien[idx++] = "VladSaturnian";
        }
        if(antenna <= 2 && eyes <= 3){
            alien[idx++] = "GraemeMercurian";
        }

        for(String str : alien){
            if(str != null){
                System.out.println(str);
            }
        }
        sc.close();
    }
}
