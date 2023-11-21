import java.util.*;

class Solution {
    public String solution(String polynomial) {
        StringTokenizer st = new StringTokenizer(polynomial, "+");
        
        int firstTerm = 0, secondTerm = 0;
        String answer = "";
        
        while(st.hasMoreTokens()){
            String term = st.nextToken().replaceAll(" ","");
            if(term.contains("x")){
                if(term.length() == 1){
                    firstTerm++;
                }
                else{
                    firstTerm += Integer.parseInt(term.replaceAll("x",""));    
                }
            }
            else{
                secondTerm += Integer.parseInt(term);
            }
        }
        
        if(firstTerm != 0){
            if(secondTerm != 0){
                if(firstTerm != 1){
                    answer = firstTerm + "x + " + secondTerm;    
                }
                else{
                    answer =  "x + " + secondTerm;
                }
            }
            else{
                if(firstTerm != 1){
                    answer = firstTerm + "x";    
                }
                else{
                    answer =  "x";
                }
            }
        }
        else{
            answer = secondTerm + "";
        }
        
        return answer;
    }
}