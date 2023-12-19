import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        String[] category = {"R","T","C","F","J","M","A","N"};
        HashMap<String, Integer> record = new HashMap<>();
        
        for(int i=0; i<category.length; i++){
            record.put(category[i], 0);
        }
        
        // 첫 번째 캐릭터는 score[1]~score[3] 까지의 점수를 획득한다.
        // 두 번째 캐릭터는 score[5]~score[7] 까지의 점수를 획득한다.
        for(int i=0; i<survey.length; i++){
            String first = survey[i].substring(0,1);
            String second = survey[i].substring(1,2);
            
            if(choices[i] < 4){
                record.put(first, record.get(first) + score[choices[i]]);
            }
            else if(choices[i] > 4 && choices[i] < 8){
                record.put(second, record.get(second) + score[choices[i]]);
            }
        }
        
        for(int i=0; i<category.length; i+=2){
            if(record.get(category[i]) == record.get(category[i+1])){
                answer += category[i];
            }
            else{
                if(record.get(category[i]) > record.get(category[i+1])){
                    answer += category[i];
                }
                else{
                    answer += category[i+1];
                }
            }
        }
        
        return answer;
    }
}