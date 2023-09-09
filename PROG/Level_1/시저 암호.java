class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        // target에 n을 더한 결과값이 각각 영문자를 벗어날 수 있으므로,
        // 영문자 범위내로 변환되도록 초과범위(26)로 나머지 연산하여 다시 순환되도록 한다.
        for(int i=0; i<s.length(); i++){
            char target = s.charAt(i);
            if(Character.isLowerCase(target)){
                target = (char)((target+n-'a')%26 + 'a');
            }
            else if(Character.isUpperCase(target)){
                target = (char)((target+n-'A')%26 + 'A');
            }
            answer += target;
        }
        
        return answer;
    }
}