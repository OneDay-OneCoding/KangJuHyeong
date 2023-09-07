import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int index = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.substring(i, i+1).equals(" ")){
                index = 0;
                answer += " ";
                continue;
            }
            else{
                if(index%2 == 0){
                    answer += s.substring(i, i+1).toUpperCase();
                }
                else if(index%2 == 1){
                    answer += s.substring(i, i+1).toLowerCase();
                }
                index++;
            }
        }
        
        return answer;
    }
}