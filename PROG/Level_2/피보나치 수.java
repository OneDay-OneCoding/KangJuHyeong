// 재귀함수로만 구성하면 시간 초과가 발생한다.
// 이미 계산한 값들을 재사용할 수 있게 해야한다.

class Solution {
    static int[] number = new int[100000+1];
    
    public int solution(int n) {
        number[0] = 0;
        number[1] = 1;
        
        int answer = fibo(n) % 1234567;
        return answer;
    }
    
    public int fibo(int n){
        if(n > 1){
            if(number[n-1] != 0 && number[n-2] != 0){
                return (number[n-2] + number[n-1]);
            }
            else if(number[n-2] != 0){
                number[n-1] = fibo(n-1) % 1234567;
                return (number[n-2] + number[n-1]);
            }
            else{
                number[n-2] = fibo(n-2) % 1234567;
                number[n-1] = fibo(n-1) % 1234567;
                
                return (number[n-2] + number[n-1]);
            }
        }
        else{
            return number[n];
        }
    }
}