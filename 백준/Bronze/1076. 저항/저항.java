import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String color = sc.nextLine();
		long ans = 10 * resistance(color, 0);
		
		color = sc.nextLine();
		ans += resistance(color, 0);
		
		color = sc.nextLine();
		ans *= resistance(color, 1);
		
		System.out.println(ans);
		
		sc.close();
	}
	
	public static long resistance(String color, int mod) {
		
		long num = 0;
		long mul = 0;
		
		switch(color) {
			case("black"):
				num = 0;
				mul = 1;
				break;
			case("brown"):
				num = 1;
				mul = 10;
				break;
			case("red"):
				num = 2;
				mul = 100;
				break;
			case("orange"):
				num = 3;
				mul = 1000;
				break;
			case("yellow"):
				num = 4;
				mul = 10000;
				break;
			case("green"):
				num = 5;
				mul = 100000;
				break;
			case("blue"):
				num = 6;
				mul = 1000000;
				break;
			case("violet"):
				num = 7;
				mul = 10000000;
				break;
			case("grey"):
				num = 8;
				mul = 100000000;
				break;
			case("white"):
				num = 9;
				mul = 1000000000;
				break;
		}
		
		if(mod == 0)
			return num;
		else if(mod == 1)
			return mul;
		
		return -1;
	}
}
