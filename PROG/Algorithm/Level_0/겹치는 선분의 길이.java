class Solution {
    public int solution(int[][] lines) {
        int[] count = new int[200+1];
        int answer = 0;
        
        for(int i=0; i<lines.length; i++){
            for(int j=(lines[i][0]+100); j<lines[i][1]+100; j++){
                count[j]++;
            }
        }
        
        for(int i=0; i<count.length; i++){
            if(count[i] > 1){
                answer++;
            }
        }
        return answer;
    }
}