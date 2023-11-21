import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] score = new int[3];
        int[] one = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for(int i=0; i<answers.length; i++){
            score[0] += (one[i%10] == answers[i]) ? 1 : 0;
            score[1] += (two[i%8] == answers[i]) ? 1 : 0;
            score[2] += (three[i%10] == answers[i]) ? 1 : 0;
        }
        
        int max = Integer.MIN_VALUE;
        int maxCount = 0;
        
        for(int i=0; i<score.length; i++){
            max = Math.max(max, score[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<score.length; i++){
            if(max == score[i]){
                list.add((i+1));
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
    
        return answer;
    }
}