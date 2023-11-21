import java.util.*;

class Solution {
    public int[] solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        int div = 2;
        
        while(n > 1){
            if(n%div == 0){
                set.add(div);
                n = (n/div);
            }
            else{
                div++;
            }
        }
        
        int[] answer = new int[set.size()];
        Iterator iter = set.iterator();
        
        for(int i=0; i<set.size(); i++){
            answer[i] = (int)iter.next();
        }
        Arrays.sort(answer);
        
        return answer;
    }
}