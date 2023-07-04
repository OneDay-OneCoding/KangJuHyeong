import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<intStrs.length; i++){
            int val = Integer.valueOf(intStrs[i].substring(s, s+l));
            if(val > k){
                list.add(val);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);    
        }
        return answer;
    }
}