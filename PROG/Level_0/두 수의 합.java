import java.math.*;

class Solution {
    public String solution(String a, String b) {
        String answer = "";
        BigInteger first = new BigInteger(a);
        BigInteger second = new BigInteger(b);
        answer = first.add(second).toString();
        return answer;
    }
}