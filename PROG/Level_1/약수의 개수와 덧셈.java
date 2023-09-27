class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            int div = 1;
            int count = 0;
            
            while(true){
                if(div == i+1){
                    break;
                }
                else{
                    if(i%div == 0){
                        count++;
                    }
                    div++;
                }
            }
            if(count%2 == 0){
                answer += i;
            }
            else if(count%2 == 1){
                answer -= i;
            }
        }
        return answer;
    }
}