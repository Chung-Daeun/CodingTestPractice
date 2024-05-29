import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}
			
		System.out.println((double)sum / max * 100 / n);
		sc.close();
	}
	
	

}
