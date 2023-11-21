class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0; // 이진 변환의 횟수
        int zero = 0; // 변환 과정에서 제거된 모든 0의 개수
        
        while(true){
            // 이진 변환의 횟수를 추가한다.
            count += 1;
            
            // x의 모든 0을 제거한다.
            int before = s.length(); // 0을 제거하기 전 문자열의 길이
            String str = s.replaceAll("0", "");
            int after = str.length(); // 0을 제거한 후 문자열의 길이
            zero += (before - after);
            s = str;
            
            // s가 1이된 경우, 탈출한다.
            if(s.equals("1")){
                break;
            }
            else{
                // s가 1이되지 않은 경우, 2진법으로 표현한 문자열의 길이를 다시 2진법으로 표현한다.
                s = Integer.toString(s.length(), 2);
            }
        }
        
        answer[0] = count;
        answer[1] = zero;
        
        
        return answer;
    }
}