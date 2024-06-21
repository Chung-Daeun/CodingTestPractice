import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> ballon = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			ballon.add(i);
		}
		
		int q = sc.nextInt();
		for(int j = 0; j < q; j++) {
			int s = sc.nextInt();
			int d = sc.nextInt();
			for(int k = s; k <= n; k += d) {
				ballon.set(k - 1, 0);				
			}
		}
		
		Set<Integer> removeBallon = new HashSet<Integer>(ballon);
		System.out.println(removeBallon.size() - 1);
		
		
		sc.close();

	}

}
