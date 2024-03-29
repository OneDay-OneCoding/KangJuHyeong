import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        
        for(int i=0; i<completion.length; i++){
            map.put(completion[i], map.get(completion[i])-1);
        }
        
        Iterator <Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}