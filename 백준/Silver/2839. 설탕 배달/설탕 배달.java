import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int pak = n / 5;
		int ans = -1;
		
		for(int i = n / 5; i >= 0; i--) {
			if((n - i * 5) % 3 == 0) {
				ans = i + (n - i * 5) / 3; 
				break;
			}
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}