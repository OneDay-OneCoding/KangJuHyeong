class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[] array = new int[1000];
        array[0] = n;
        int count = 0;
        
        while(true){
            if(n!=1){
                if(n%2==0){
                    n = n/2;
                }
                else{
                    n = (3 * n) + 1;
                }
                array[++count] = n;
            }
            else{
                array[++count] = n;
                break;
            }
        }
        
        answer = new int[count];
        for(int i=0; i<count; i++){
            answer[i] = array[i];
        }
        
        return answer;
    }
}