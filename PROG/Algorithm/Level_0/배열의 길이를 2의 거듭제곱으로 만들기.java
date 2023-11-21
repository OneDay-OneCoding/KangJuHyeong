class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int count = 1;
        while(true){
            if(count < arr.length){
                count *= 2;
            }
            else{
                break;
            }
        }
        answer = new int[count];
        for(int i=0; i<arr.length; i++){
            answer[i] = arr[i];
        }
        return answer;
    }
}