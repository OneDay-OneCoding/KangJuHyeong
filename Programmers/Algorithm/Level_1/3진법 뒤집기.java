class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // STEP1. 10진수 -> 3진수 변환
        String ternary = Integer.toString(n, 3);
        
        // STEP2. 3진수 반전
        StringBuilder sb = new StringBuilder(ternary);
        ternary = sb.reverse().toString();
        
        // STEP3. 3진수 -> 10진수 변환
        answer = Integer.parseInt(ternary, 3);
        
        return answer;
    }
}