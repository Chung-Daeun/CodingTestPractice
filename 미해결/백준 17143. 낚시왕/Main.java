package shark;
내일부터 꼭 매일 잔디를 심으리라
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int weight = 0;
	static List<Shark> sharks = new LinkedList<Shark>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// r, c를 인덱스로 생각해서 계산
		int r = sc.nextInt();
		int c = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int rs = sc.nextInt();
			int cs = sc.nextInt();
			int ss = sc.nextInt();
			int ds = sc.nextInt();
			int zs = sc.nextInt();
			
			sharks.add(new Shark(rs, cs, ss, ds, zs));
			if(2 * r <= ss || 2 * c <= ss) {
				Shark.newS(sharks.get(i), ds, ss, r, c);				
			}
		}
		
		// r기준으로 정렬
		sharks.sort((o1, o2) -> o1.r - o2.r);
		
		for(int i = 0; i < c; i++) {
			Shark.catchShark(i);		// 잡고
			Shark.sharkMove(r - 1, c - 1);	// 이동하고
			Shark.eatShark();			// 먹고
			sharks.sort((o1, o2) -> o1.r - o2.r); // 정렬
		}
		
		System.out.println(weight);
		
		sc.close();
	}
	
	public static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r - 1;
			this.c = c - 1;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
		public static void newS(Shark shark, int d , int s, int r, int c) {
			switch(d) {
				case 1: case 2:
					shark.s = s % (2 * r);
					break;
				case 3: case 4: 
					shark.s = s % (2 * c);
					break;
			}
		}
		
		// 메소드의 매개변수 r과 c는 모두 그물(?)의 행렬값이다.
		public static void sharkMove(int r, int c) {
			for(int i = 0;  i < sharks.size(); i++) {
				Shark shark = sharks.get(i);
				switch(shark.d) {
				case 1:
					shark.r -= shark.s;
					sharks.set(i, shark.sharkUp(shark, r));
					break;
				case 2:
					shark.r += shark.s;
					sharks.set(i, shark.sharkDown(shark, r));
					break;
				case 3:
					shark.c += shark.s;
					sharks.set(i, shark.sharkRight(shark, c));
					break;
				case 4:
					shark.c -= shark.s;
					sharks.set(i, shark.sharkLeft(shark, c));
					break;
				}
				
			}
		}
		
		public Shark sharkUp(Shark shark, int r) {
			if(shark.r < 0) {
				shark.r = (int)Math.abs(shark.r);
				shark.d = 2;
			}
			if(shark.r > r) {
				shark = shark.sharkDown(shark, r);
			}
			return shark;
		}
		
		public Shark sharkDown(Shark shark, int r) {
			if(shark.r > r) {
				shark.r = 2 * r - shark.r;
				shark.d = 1;
			}
			if(shark.r < 0) {
				shark = shark.sharkUp(shark, r);
			}
			return shark;
		}
		
		public Shark sharkRight(Shark shark, int c) {
			if(shark.c > c) {
				shark.c = 2 * c - shark.c;
				shark.d = 4;
			}
			if(shark.c < 0) {
				shark = shark.sharkLeft(shark, c);
			}
			return shark;
		}
		
		public Shark sharkLeft(Shark shark, int c) {
			if(shark.c < 0) {
				shark.c = (int)Math.abs(shark.c);
				shark.d = 3;
			}
			if(shark.c > c) {
				
			}
			return shark;
		}
		
		public static void catchShark(int man) {
			for(int i = 0; i < sharks.size(); i++) {
				Shark shark = sharks.get(i);
				if(man == shark.c) {
					weight += shark.z;
					sharks.remove(i);
					break;
				}
			}
		}
		
		public static void eatShark() {
			for(int i = 0; i < sharks.size() - 1; i++) {
				for(int j = i + 1; j < sharks.size(); j++ ) {
					if(sharks.get(i).r == sharks.get(j).r && sharks.get(i).c == sharks.get(j).c) {
						if (sharks.get(i).z > sharks.get(j).z) {
							sharks.remove(sharks.get(j));
							j--;
						} else if (sharks.get(i).z < sharks.get(j).z){
							sharks.remove(sharks.get(i));
							i--;
							break;
						}
					}
				}
			}
		}
		
	}

}
