import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");

        if(str[0].equals("")){
            System.out.println(0);
        }else{
            System.out.println(str.length);
        }
    }
}
