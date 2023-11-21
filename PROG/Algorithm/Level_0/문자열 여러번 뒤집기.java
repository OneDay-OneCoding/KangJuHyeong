import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        char[] array = my_string.toCharArray();
        for(int i=0; i<queries.length; i++){
            String reverseString = "";
            StringBuilder sb = new StringBuilder();
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                reverseString += array[j];
            }
            sb.append(reverseString);
            reverseString = sb.reverse().toString();
            
            char[] reverseArray = reverseString.toCharArray();
            int index = 0;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                array[j] = reverseArray[index++];
            }
        }
        answer = new String(array);
        return answer;
    }
}