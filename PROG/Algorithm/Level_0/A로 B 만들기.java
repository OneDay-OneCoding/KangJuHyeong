class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        
        char[] beforeArray = before.toCharArray();
        char[] afterArray = after.toCharArray();
        char[] beforeCheck = new char[26];
        char[] afterCheck = new char[26];
        
        for(int i=0; i<beforeArray.length; i++){
            beforeCheck[beforeArray[i]-'a']++;
            afterCheck[afterArray[i]-'a']++;
        }
        
        for(int i=0; i<beforeCheck.length; i++){
            if(beforeCheck[i] != afterCheck[i]){
                answer = 0;
            }
        }
        
        return answer;
    }
}