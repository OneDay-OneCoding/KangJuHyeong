class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(true){
            if(chicken >= 10){
                chicken -= 9;
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}