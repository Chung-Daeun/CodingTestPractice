import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x, y , dist, max;
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			dist = y - x;
			max = (int)Math.sqrt(dist);
			
			if(Math.sqrt(dist) == max) {
				ans = 2 * max - 1;
			} else if(dist <= max * (max + 1)) {
				ans = 2 * max;
			} else {
				ans = 2 * max + 1;
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
