import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<answer.length; i++){
            int target = prices[i];
            int count = 0;
            
            for(int j=i+1; j<prices.length; j++){
                count += 1;
                if(prices[j] < target){
                    break;
                }
            }
            
            answer[i] = count;
        }
        return answer;
    }
}