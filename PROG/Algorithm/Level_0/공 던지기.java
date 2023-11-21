class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int index = 0;
        while(true){
            if(k>0){
                k--;
                answer = numbers[index];
                index = (index+2) % numbers.length;
            }
            else{
                break;
            }
        }
        return answer;
    }
}