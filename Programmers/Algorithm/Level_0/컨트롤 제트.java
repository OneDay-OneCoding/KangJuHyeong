import java.util.*;

class Solution {
    public int solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int answer = 0;
        int preInput = Integer.parseInt(st.nextToken());
        if(!st.hasMoreTokens()){
            answer += preInput;
        }
        
        while(st.hasMoreTokens()){
            String input = st.nextToken();
            if(input.equals("Z")){
                preInput = 0;
            }
            else{
                answer += preInput;
                preInput = Integer.parseInt(input);
                if(!st.hasMoreTokens()){
                    answer += preInput;
                }
            }
        }
        
        return answer;
    }
}