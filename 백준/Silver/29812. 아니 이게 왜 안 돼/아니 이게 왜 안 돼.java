import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력값 저장
		int n = sc.nextInt();	// 문자열 길이
		sc.nextLine();
		String str = sc.nextLine(); // 문자열
		int d = sc.nextInt();	// delete 에너지
		int m = sc.nextInt();	// 드래그 에너지
		
		// 출력해야하는 정보
		int eSum = 0;
		int hyuNum;
		
		// 그 외 필요한 것
		List<Character> drag = new ArrayList<Character>();
		Map<Character, Integer> hyuMap = new HashMap<Character, Integer>();
		hyuMap.put('H', 0);
		hyuMap.put('Y', 0);
		hyuMap.put('U', 0);
		
		for(int i = 0; i < n; i++) {
			switch(str.charAt(i)) {
				case 'H': case 'Y': case 'U':
					char ch = str.charAt(i);
					hyuMap.put(ch, hyuMap.get(ch) + 1);
					
					if(!drag.isEmpty()) {
						eSum += Math.min(d * drag.size(), d + m);
						drag.clear();
					}
					break;
				default:
					drag.add(str.charAt(i));
			}
		}
		
		// 마지막 덩어리도 처리해야함.
		eSum += Math.min(d * drag.size(), d + m);
		
		hyuNum = Math.min(Math.min(hyuMap.get('H'), hyuMap.get('Y')), hyuMap.get('U'));
		
		if(eSum == 0) {
			System.out.println("Nalmeok");
		} else {
			System.out.println(eSum);
		}
		
		if(hyuNum == 0) {
			System.out.println("I love HanYang University");
		} else {
			System.out.println(hyuNum);
		}
		
	}

}
