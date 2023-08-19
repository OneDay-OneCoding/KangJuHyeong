class Solution {
    public int solution(int num) {
        int answer = 0;
        int count = 0;
        
        while(true){
            if(num == 1){
                answer = 0;
                break;
            }
            else if(count > 500){
                answer = -1;
                break;
            }
            else{
                count++;
                if(num%2 == 0){
                    num /= 2;
                }
                else if(num%2 == 1){
                    num *= 3;
                    num += 1;
                }
                
                if(num == 1){
                    answer = count;
                    break;
                }
            }
        }
        return answer;
    }
}