class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        int start = -1;
        int end = -1;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i]==2){
                if(start==-1){
                    start = i;
                }
                end = i;
            }
        }
        
        if(start!=-1 && end!=-1){
            answer = new int[end-start+1];
            for(int i=0; i<answer.length; i++){
                answer[i] = arr[start + i];
            }    
        }
        else{
            answer = new int[1];
            answer[0] = -1;
        }
        
        return answer;
    }
}