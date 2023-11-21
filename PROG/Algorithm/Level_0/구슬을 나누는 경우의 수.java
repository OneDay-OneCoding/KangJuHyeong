import java.math.*;

class Solution {
    public int solution(int balls, int share) {
        BigInteger answer = new BigInteger("1");
        
        if(share > (balls/2)){
            share = balls - share;
        }
        
        for(int i=balls; i>(balls-share); i--){
            answer = answer.multiply(new BigInteger(Integer.toString(i)));
        }
        
        for(int i=share; i>1; i--){
            answer = answer.divide(new BigInteger(Integer.toString(i)));
        }
        
        return Integer.parseInt(answer.toString());
    }
}