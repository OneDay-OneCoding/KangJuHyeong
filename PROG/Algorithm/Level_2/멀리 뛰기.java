// 재귀로 풀이하면 시간 초과가 발생한다.
// 점화식을 구성하여 DP로 풀어보자.

class Solution {
    public long solution(int n) {
        // n은 1이상, 2000 이하인 정수이다.
        long[] dp = new long[2001];
        
        // dp[3] = 3, dp[4] = 5, ... 
        // dp[i] = dp[i-2] + dp[i-1]
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i=3; i<2001; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        
        return (dp[n] % 1234567);
    }
}

/*
class Solution {
    static long answer = 0;
    
    public long solution(int n) {
        jump(n, 0);
        return answer % 1234567;
    }
    
    // n : 도달해야하는 끝 칸, d : 현재 위치
    public void jump(int n, int d){
        if(n == d){
            answer += 1;
            return;
        }
        else{
            if(n < d){
                return;
            }
            jump(n, d+1);
            jump(n, d+2);
        }
    }
}
*/