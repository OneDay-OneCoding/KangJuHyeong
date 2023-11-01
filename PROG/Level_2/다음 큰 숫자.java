class Solution {
    public int solution(int n) {
        int answer = 0;
        int next = n+1;
        
        char[] array = Integer.toString(n, 2).toCharArray();
        int countN = 0; // n을 2진수로 변환했을 때, 1의 개수
        int countNext = 0; // next를 2진수로 변환했을 때, 1의 개수
        
        for(int i=0; i<array.length; i++){
            if(array[i] == '1'){
                countN++;
            }
        }
        
        while(true){
            char[] arrayNext = Integer.toString(next,2).toCharArray(); 
            for(int i=0; i<arrayNext.length; i++){
                if(arrayNext[i] == '1'){
                    countNext++;
                }
            }
            
            if(countN == countNext){
                answer = next;
                break;
            }    
            else{
                countNext = 0;
                next += 1;
            }
        }
        
        return answer;
    }
}