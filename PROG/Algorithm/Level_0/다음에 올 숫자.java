class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int firstDiff = common[1] - common[0];
        int secondDiff = common[2] - common[1];
        
        if(firstDiff == secondDiff){
            answer = common[common.length-1] + firstDiff;
        }
        else{
            int multiple = common[1] / common[0];
            answer = common[common.length-1] * multiple;
        }
        return answer;
    }
}