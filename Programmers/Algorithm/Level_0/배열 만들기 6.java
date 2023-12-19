import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();
        
        int i = 0;
        while(true){
            if(i == arr.length){
                break;
            }
            else{
                if(stk.size() == 0){
                    stk.add(arr[i++]);
                }
                else{
                    if(stk.get(stk.size()-1) == arr[i]){
                        stk.remove(stk.size()-1);
                        i++;
                    }
                    else{
                        stk.add(arr[i++]);
                    }
                }
            }
        }
        
        if(stk.size() == 0){
            int[] array = {-1};
            return array;
        }
        
        return stk.stream().mapToInt(j->j).toArray();
    }
}