class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int[] answer = {};
        
        int count = 0;
        for(int i=0; i<intervals.length; i++){
            count += intervals[i][1]-intervals[i][0]+1;
        }
        answer = new int[count];
        
        int index = 0;
        for(int i=0; i<intervals.length; i++){
            for(int j=intervals[i][0]; j<=intervals[i][1]; j++){
                answer[index++] = arr[j];
            }    
        }
        return answer;
    }
}