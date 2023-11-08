// 재귀로 풀면 효율성 테스트를 통과하지 못한다.

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        while(true){
            if(n == 0){
                break;
            }
            else{
                if(n%2 == 0){
                    n /= 2;
                }        
                else{
                    answer += 1;
                    n -= 1;
                }
            }
        }
        
        return answer;
    }
}