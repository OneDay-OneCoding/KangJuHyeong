class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] array = new int[number+1];
        
        for(int i=1; i<=number; i++){
            for(int j=1; j*j<=i; j++){
                if(i == j*j){
                    array[i]++;
                }
                else if(i%j == 0){
                    array[i] += 2;
                }
            }
        }
        
        for(int i=1; i<array.length; i++){
            if(array[i] <= limit){
                answer += array[i];
            }
            else{
                answer += power;
            }
        }
        return answer;
    }
}