class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        String compare = "";
        int index = 0;
        
        for(int i=pat.length(); i<=myString.length(); i++){
            compare = myString.substring(i-pat.length(), i);
            if(compare.contains(pat)){
                index = i;    
            }
        }
        answer = myString.substring(0, index);
        
        return answer;
    }
}