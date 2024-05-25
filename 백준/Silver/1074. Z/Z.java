import java.util.Scanner;
public class Main {
	static int ans = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		inputValue(n, r, c);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static void inputValue(int n, int r, int c ) {
		int i = 1 << n - 1;
		
		if(i > 0) {
			// 1사분면
			if (r < i && c < i) {
				inputValue(n - 1, r, c);
			} else if (r < i && c >= i) {
				ans += i * i;
				inputValue(n - 1, r, c - i);
			} else if (r >= i && c < i) {
				ans += 2 * i * i;
				inputValue(n - 1, r - i, c);
			} else { 
				ans += 3 * i * i;
				inputValue(n - 1, r - i, c - i);
			}
		}
		
	}

}
