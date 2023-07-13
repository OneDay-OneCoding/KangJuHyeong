class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] array = new int[31];
        for(int i=0; i<strArr.length; i++){
            array[strArr[i].length()]++;
        }
        
        for(int i=0; i<array.length; i++){
            answer = Math.max(answer, array[i]);    
        }
        return answer;
    }
}