import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        double[] avg =  new double[score.length];
        double[] ascendAvg = new double[score.length];
        
        for(int i=0; i<score.length; i++){
            avg[i] = (double)(score[i][0] + score[i][1])/2;
            ascendAvg[i] = avg[i];
        }
        Arrays.sort(ascendAvg);
        
        for(int i=0; i<ascendAvg.length; i++){
            for(int j=0; j<avg.length; j++){
                if(ascendAvg[i] == avg[j]){
                    answer[j] = (score.length-i);
                }
            }
        }
        
        return answer;
    }
}