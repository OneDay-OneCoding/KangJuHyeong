import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet<>();
        
        // 간단한 조합이므로, 반복문을 이용하여 구성한다.
        for(int i=0; i<numbers.length; i++){
            for(int j=0; j<numbers.length; j++){
                if(i != j){
                    set.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        answer = new int[set.size()];
        int index = 0;
        
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            answer[index++] = (Integer)iter.next();
        }
        Arrays.sort(answer);
        
        return answer;
    }
}