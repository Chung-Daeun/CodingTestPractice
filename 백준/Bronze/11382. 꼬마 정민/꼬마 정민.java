import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
		String[] str = sc.nextLine().split(" ");
		
        long a = Long.parseLong(str[0]);
        long b = Long.parseLong(str[1]);
        long c = Long.parseLong(str[2]);
        
        System.out.println(a + b + c);
        
        sc.close();
    
	}

}