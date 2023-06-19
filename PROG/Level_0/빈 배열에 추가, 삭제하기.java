import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(flag[i]){
                for(int j=0; j<arr[i]*2; j++){
                    array.add(arr[i]);
                }    
            }
            else{
               for(int j=0; j<arr[i]; j++){
                    array.remove(array.size()-1);
                } 
            }
        }
        
        int[] answer = new int[array.size()];
        for(int i=0; i<array.size(); i++){
            answer[i] = array.get(i);
        }
        return answer;
    }
}