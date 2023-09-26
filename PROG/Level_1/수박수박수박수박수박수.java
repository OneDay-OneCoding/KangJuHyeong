class Solution {
    public String solution(int n) {
        String answer = "";
        int count = 0;
        
        while(true){
            if(count == n){
                break;
            }
            else{
                if(count%2 == 0){
                    answer += "수";
                }
                else if(count%2 == 1){
                    answer += "박";
                }
                count++;
            }
        }
        return answer;
    }
}