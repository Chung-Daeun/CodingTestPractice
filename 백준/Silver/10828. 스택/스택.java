import java.util.*;

public class Main{
	
	static List<Integer> stack = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder output = new StringBuilder();
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String str = sc.next();
			
			switch(str) {
				case("push"):
					int l = sc.nextInt();
					stack.add(l);
					break;
				case("pop"):
					if(stack.isEmpty())	output.append(-1).append("\n");
					else {
						output.append(stack.get(stack.size() - 1)).append("\n");
						stack.remove(stack.size() - 1);
					}
					break;
				case("size"):
					output.append(stack.size()).append("\n");
					break;
				case("empty"):
					output.append(stack.isEmpty()? 1 : 0).append("\n");
					break;
				case("top"):
					if(stack.isEmpty())	output.append(-1).append("\n");
					else output.append(stack.get(stack.size() - 1)).append("\n");
					break;
			}
			
		}
		
		System.out.print(output);
		sc.close();
	}
}