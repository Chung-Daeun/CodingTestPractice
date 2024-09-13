class Solution {
    public int solution(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(!is_nonprime(nums[i] + nums[j] + nums[k])){
                        cnt++;
                    }
                }
            }
        };

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return cnt;
    }
    
    public boolean is_nonprime(int num) {
        boolean[] is_nonprime = new boolean[3000];
        
        is_nonprime[0] = true;
        for(int i = 1; i < 3000; i++){
            for(int j = i + (i + 1); j < 3000; j += (i + 1)){
                is_nonprime[j] = true;
            }
        }
        
        return is_nonprime[num - 1];
    }
}