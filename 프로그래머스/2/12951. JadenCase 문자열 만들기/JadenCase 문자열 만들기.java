class Solution {
    public String solution(String s) {
        String answer = "";
        Boolean start = true;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                start = true;
                answer += ch;
                continue;
            }
            
            if (start) {
                answer += Character.toUpperCase(ch);
                start = false;
            } else {
                answer += Character.toLowerCase(ch);
            }
        }
        
        return answer;
    }
}