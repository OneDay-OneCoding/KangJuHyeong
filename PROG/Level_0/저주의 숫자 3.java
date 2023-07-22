class Solution {
    public int solution(int n) {
        int answer = 1;
        int decimal = 1;
        
        while(true){
            if(decimal == n){
                while(true){
                    if(answer%3 == 0){
                        answer++;
                    }
                    else if(Integer.toString(answer).contains("3")){
                        answer++;
                    }
                    else{
                        break;
                    }    
                }
                break;
            }
            else if(answer%3 == 0){
                answer++;
            }
            else if(Integer.toString(answer).contains("3")){
                answer++;
            }
            else{
                answer++;
                decimal++;
            }
        }
        return answer;
    }
}