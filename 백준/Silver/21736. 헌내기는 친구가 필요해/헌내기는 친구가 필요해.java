import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int person = 0;
	static List<List<Character>> building = new ArrayList<List<Character>>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 도연이 위치
		int pr = -1;
		int pc = -1;
		
		// 입력값 저장, 도연이 위치 파악
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		
		
		for(int i = 0; i < r ; i++) {
			String str = sc.nextLine();
			building.add(new ArrayList<Character>());
			for(int j = 0; j < c; j++) {
				building.get(i).add(str.charAt(j));
				if (str.charAt(j) == 'I') {
					pr = i;
					pc = j;
				}
			}
		}
		
		meetPeople(pr, pc, 's');
		if(person == 0) {
			System.out.println("TT");
		} else {
			System.out.println(person);			
		}
		
		sc.close();
	}
	// u: 위로 올라감. d: 아래로 내려감. r: 오른쪽으로 감. l: 왼쪽으로 감.
	public static void meetPeople(int r, int c, char dir) {
		if(building.get(r).get(c) != 'X' && building.get(r).get(c) != 'A') {
			if(building.get(r).get(c) == 'P') {
				person += 1;
			}
			// 왔다 간 것을 표시
			building.get(r).set(c, 'A');
			
			// 위쪽으로 이동
			if((r - 1 >= 0) && dir != 'd') {
				meetPeople(r - 1, c , 'u');
			}
			// 아래쪽으로 이동
			if((r + 1 < building.size()) && dir != 'u') {
				meetPeople(r + 1, c , 'd');
			}
			// 왼쪽으로 이동
			if((c - 1 >= 0) && dir != 'r') {
				meetPeople(r, c - 1 , 'l');
			}
			// 오른쪽으로 이동
			if((c + 1 < building.get(0).size()) && dir != 'l') {
				meetPeople(r, c + 1 , 'r');
			}
		}
	}
}
