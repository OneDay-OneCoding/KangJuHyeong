import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        char[] array = my_string.toCharArray();
        String[] answer = new String[array.length]; 
        
        for(int i=0; i<array.length; i++){
            String str = "";
            for(int j=i; j<array.length; j++){
                str += array[j];
            }
            answer[i] = new String(str);
        }
        Arrays.sort(answer);
        return answer;
    }
}