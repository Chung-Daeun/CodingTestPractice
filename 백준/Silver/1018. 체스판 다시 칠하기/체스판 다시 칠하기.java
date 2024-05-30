import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	// 옮겨야하는 횟수 저장하는 리스트 선언
	static List<Integer> moveList = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] coloring = {"WBWBWBWB", "BWBWBWBW"};
		
		// 입력값 저장
		int r = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		
		List<String> chess = new ArrayList<String>();
		for(int i = 0; i < r; i++) {
			chess.add(sc.nextLine());
		}
		
		// 쪼갠 결과 답을 배열 선언
		List<String> chessList = new ArrayList<String>();
		
		
		if(r == 8 && c == 8) {
			checkChess(chess);
		} else {
			for(int i = 0; i <= r - 8; i++) {
				for(int j = 0; j <= c - 8; j++) {
					for(int k = i; k < i + 8; k ++) {
						chessList.add(chess.get(k).substring(j, j + 8));
					}
					checkChess(chessList);
					chessList.clear();
				}
			}
		}
		
		Collections.sort(moveList);
		System.out.println(moveList.get(0));
		
		sc.close();
	}
	
	public static void checkChess(List<String> strList ) {
		int num0 = 0;
		int num1 = 0;
		
		num0 += checkBlock(0,strList.get(0));
		num0 += checkBlock(1,strList.get(1));
		num0 += checkBlock(0,strList.get(2));
		num0 += checkBlock(1,strList.get(3));
		num0 += checkBlock(0,strList.get(4));
		num0 += checkBlock(1,strList.get(5));
		num0 += checkBlock(0,strList.get(6));
		num0 += checkBlock(1,strList.get(7));
		
		num1 += checkBlock(1,strList.get(0));
		num1 += checkBlock(0,strList.get(1));
		num1 += checkBlock(1,strList.get(2));
		num1 += checkBlock(0,strList.get(3));
		num1 += checkBlock(1,strList.get(4));
		num1 += checkBlock(0,strList.get(5));
		num1 += checkBlock(1,strList.get(6));
		num1 += checkBlock(0,strList.get(7));
		
		moveList.add(Math.min(num0, num1));
	}
	
	public static int checkBlock(int num, String str) {
		String[] coloring = {"WBWBWBWB", "BWBWBWBW"};
		int re = 0;
		
		switch(num) {
			case 0:
				for(int i = 0; i < 8; i++) {
					if(coloring[0].charAt(i) != str.charAt(i))
						re += 1;
				}
				break;
			case 1:
				for(int i = 0; i < 8; i++) {
					if(coloring[1].charAt(i) != str.charAt(i))
						re += 1;
				}
				break;
		}
		return re;
	}
}
