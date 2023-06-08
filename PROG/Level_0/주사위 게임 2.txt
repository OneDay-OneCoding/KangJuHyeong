import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        
        // Case1. 세 숫자가 모두 다른 경우
        if((a!=b) && (b!=c) && (a!=c)){
            answer = (a+b+c);
        }
        else{
            // Case2. 두 숫자는 같고 나머지 숫자는 다른 경우
            if(((a==b) && (b!=c)) || ((b==c) && (a!=b)) || ((a==c) && (a!=b))){
                answer = (a+b+c) * (a*a + b*b + c*c);
            }
            // Case3. 세 숫자가 모두 같은 경우
            else{
                answer = (a+b+c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
            }
        }
        
        return answer;
    }
}