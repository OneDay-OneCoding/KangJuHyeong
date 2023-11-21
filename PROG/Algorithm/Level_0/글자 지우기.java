import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        char[] array = my_string.toCharArray();
        int index = 0;
        
        Arrays.sort(indices);
        for(int i=0; i<array.length; i++){
            if(index<indices.length){
                if(i!=indices[index]){
                    answer += array[i];    
                }
                else{
                    index++;
                }
            }
            else{
                answer += array[i];
            }
        }
        return answer;
    }
}