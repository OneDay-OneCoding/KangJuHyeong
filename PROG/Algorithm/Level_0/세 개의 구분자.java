import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        StringTokenizer st = new StringTokenizer(myStr, "a|b|c");
        int count = st.countTokens();
        String[] answer = new String[count];
        
        for(int i=0; i<count; i++){
            answer[i] = st.nextToken();
        }
        if(count==0){
            answer = new String[1];
            answer[0] = "EMPTY";
        }
        return answer;
    }
}