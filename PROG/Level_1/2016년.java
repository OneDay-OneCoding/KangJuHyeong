class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] calendar = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int count = b-1;
        
        for(int i=0; i<(a-1); i++){
            count += calendar[i];    
        }
        count %= 7;
        
        answer = day[count];
        return answer;
    }
}