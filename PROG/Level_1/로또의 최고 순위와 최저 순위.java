class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {6,6};
        int correct = 0;
        int zeroCount = 0;
        int[] rank = {6,5,4,3,2};
        
        for(int i=0; i<lottos.length; i++){
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    correct++;
                    break;
                }
            }
            if(lottos[i] == 0){
                zeroCount++;
            }
        }
        
        for(int i=0; i<rank.length; i++){
            if(correct+zeroCount == rank[i]){
                answer[0] = i+1;
            }
            if(correct == rank[i]){
                answer[1] = i+1;
            }
        }
        
        return answer;
    }
}