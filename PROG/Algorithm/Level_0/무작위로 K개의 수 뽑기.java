import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        
        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        Iterator iter = set.iterator();
        
        for(int i=0; i<k; i++){
            answer[i] = -1;
        }
        
        for(int i=0; i<k; i++){
            if(iter.hasNext()){
                answer[i] = (int)iter.next();    
            }
        }
        return answer;
    }
}