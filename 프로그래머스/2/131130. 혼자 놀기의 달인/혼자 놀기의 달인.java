import java.util.*;

class Solution {
    
    public int solution(int[] cards) {
        int answer = 0;
        int num1, num2;
        boolean[] isOpened = new boolean[cards.length];
        Object[] box1, box2;
        
        for (int i = 0; i < cards.length; i++) {
            num1 = 0;
            Arrays.fill(isOpened, false);
            
            box1 = opening(i, num1, cards, isOpened);
            num1 = (int)box1[0];
            isOpened = (boolean[])box1[1];
            
            if (num1 < cards.length) {
                for (int j = 0; j < cards.length; j++) {
                    num2 = 0;
                    if (!isOpened[j]) {
                        box2 = opening(j, num2, cards, isOpened);
                        num2 = (int)box2[0];
                    }
                    
                    if (num1 * num2 > answer) {
                        answer = num1 * num2;
                    }
                }
            }
            
        }
        return answer;
    }
    
    public Object[] opening(int index, int cnt, int[] cards, boolean[] isOpened) {
        isOpened[index] = true;
        int num = cards[index];
        
        if (!isOpened[num - 1]) {
            return opening(num - 1, cnt + 1, cards, isOpened);
        }
        
        return new Object[]{cnt + 1, isOpened};
        
    }
}