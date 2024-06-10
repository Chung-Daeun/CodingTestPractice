import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int x = sc.nextInt();
		
		int[] intArr = new int[num];
		for(int i = 0; i < num; i++) {
			intArr[i] = sc.nextInt();
			if(intArr[i] < x) {
				System.out.print(intArr[i] + " ");
			}
		}
		sc.close();
	}
	
	

}
