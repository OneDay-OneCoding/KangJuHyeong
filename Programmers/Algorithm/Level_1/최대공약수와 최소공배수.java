class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcd = 1;
        int lcm = 0;
        
        for(int i=1; i<=Math.max(n,m); i++){
            if((n%i == 0) && (m%i == 0)){
                gcd = i;
            }
        }
        lcm = (n*m)/gcd;
        
        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }
}