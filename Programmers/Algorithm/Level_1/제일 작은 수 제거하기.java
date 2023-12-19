import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = Integer.MAX_VALUE;
        
        List<Integer> list = new ArrayList<>();
        if(arr.length == 1){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            for(int i=0; i<arr.length; i++){
                min = Math.min(arr[i], min);
                list.add(arr[i]);
            }

            for(int i=0; i<list.size(); i++){
                if(list.get(i) == min){
                    list.remove(i);
                }
            }
            answer = list.stream().mapToInt(i->i).toArray();
        }
        
        return answer;
    }
}