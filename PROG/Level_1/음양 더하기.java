class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            int value = absolutes[i];
            if(!signs[i]){
                value *= -1;
            }
            answer += value;
        }
        return answer;
    }
}