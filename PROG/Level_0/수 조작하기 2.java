class Solution {
    public String solution(int[] numLog) {
        String answer = "";
        int[] previous = new int[numLog.length];
        for(int i=1; i<numLog.length; i++){
            previous[i] = numLog[i] - numLog[i-1];
            if(previous[i]==1){
                answer += "w";
            }
            else if(previous[i]==-1){
                answer += "s";
            }
            else if(previous[i]==10){
                answer += "d";
            }
            else if(previous[i]==-10){
                answer += "a";
            }
        }
        
        return answer;
    }
}