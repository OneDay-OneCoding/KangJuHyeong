class Solution {
    public String solution(int q, int r, String code) {
        String answer = "";
        char[] array = code.toCharArray();
        
        for(int i=0; i<code.length(); i++){
            if((i%q)==r){
                answer += array[i];
            }
        }
        return answer;
    }
}