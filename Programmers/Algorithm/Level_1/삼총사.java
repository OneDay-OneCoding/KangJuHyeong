// N=3인 조합이므로, 반복문으로 해결할 수 있다.

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1; j<number.length-1; j++){
                for(int k=j+1; k<number.length; k++){
                    if(number[i] + number[j] + number[k] == 0){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}