class Solution {
    public int solution(int n) {
        int answer = 0;
        int div = 1;
        
        while(true){
            if(div == n){
                break;
            }
            else{
                if(n%div == 1){
                    answer = div;
                    break;
                }
                else{
                    div++;
                }
            }
        }
        return answer;
    }
}