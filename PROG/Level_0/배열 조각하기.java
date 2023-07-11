import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        
        for(int i=0; i<query.length; i++){
            if(i%2 != 0){
                for(int j=0; j<query[i]; j++){
                    list.remove(0);
                }
            }
            else{
                int size = list.size();
                for(int j=query[i]; j<size-1; j++){
                    list.remove(list.size()-1);
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}