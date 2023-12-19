import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        for(int i=0; i<answer.length; i++){
            int[] copy = Arrays.copyOfRange(score, 0, i+1);
            Arrays.sort(copy);
            
            if(i < k){
                answer[i] = copy[0];
            }
            else{
                answer[i] = copy[i-k+1];
            }
        }
        
        return answer;
    }
}