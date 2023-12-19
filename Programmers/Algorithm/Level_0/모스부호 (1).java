import java.util.*;

class Solution {
    public String solution(String letter) {
        StringTokenizer st = new StringTokenizer(letter, " ");
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                          "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
                          "...-",".--","-..-","-.--","--.."};
        
        while(st.hasMoreTokens()){
            String alphabet = st.nextToken();
            for(int i=0; i<morse.length; i++){
                if(alphabet.equals(morse[i])){
                    char alpha = (char)('a' + i);
                    answer += alpha;
                }
            }
        }
        
        return answer;
    }
}