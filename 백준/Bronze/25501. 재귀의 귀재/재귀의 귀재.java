import java.util.Scanner;

public class Main{
	static int cnt = 0;
    public static int recursion(StringBuffer sb, int l, int r){
    	cnt++;
        if(l >= r) return 1;
        else if(sb.charAt(l) != sb.charAt(r)) return 0;
        else return recursion(sb, l+1, r-1);
    }
    public static int isPalindrome(StringBuffer sb){
        return recursion(sb, 0, sb.length()-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n; i++) {
        	StringBuffer sb = new StringBuffer(sc.next());
        	cnt = 0;
        	System.out.println(isPalindrome(sb) + " " + cnt);        	
        }
        
        sc.close();
    }
}
