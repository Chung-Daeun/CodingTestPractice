import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.annotation.processing.SupportedSourceVersion;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		StringBuilder sb = new StringBuilder(sc.nextLine().toUpperCase());
		
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) < 'A' || sb.charAt(i) > 'Z')
				break;
			if(map.isEmpty() || !map.containsKey(sb.charAt(i))) {
				map.put(sb.charAt(i), 1);
			} else {
				map.put(sb.charAt(i), map.get(sb.charAt(i)) + 1);
			}
		}
		
		List<Character> maxC = new ArrayList<Character>();
		int max = 0;
		Iterator<Entry<Character, Integer>> entryIt = map.entrySet().iterator();
		
		while(entryIt.hasNext()) {
			Entry<Character, Integer> entry = entryIt.next();
			if (max < entry.getValue()) {
				max = entry.getValue();
				maxC.clear();
				maxC.add(entry.getKey());
			} else if (max == entry.getValue()) {
				maxC.add(entry.getKey());
			}
		}
		
		if (maxC.size() > 1) {
			System.out.println("?");
		} else {
			System.out.println(maxC.get(0));
		}
		sc.close();
	}

}
