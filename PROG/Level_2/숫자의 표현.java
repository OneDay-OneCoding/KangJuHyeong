class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1;
        int number = 0;
        int plus = start;
        
        while(true){
            if(start > n){
                break;
            }    
            else{
                if(number == n){
                    answer += 1;
                    start += 1;
                    number = 0;
                    plus = start;
                }
                else{
                    if(number > n){
                        start += 1;
                        number = 0;
                        plus = start;
                    }
                    else{
                        number += plus++;    
                    }
                }
            }
        }
        
        return answer;
    }
}