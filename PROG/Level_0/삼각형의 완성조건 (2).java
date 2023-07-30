import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int maxSide = sides[1];
        int minSide = sides[0];
        int answer = 0;
        
        // Case1. 가장 긴 변이 maxSide인 경우
        for(int i=(maxSide-minSide+1); i<=maxSide; i++){
            answer++;
        }
        
        // Case2. 나머지 한 변이 가장 긴 변인 경우
        for(int i=(maxSide+1); i<(maxSide+minSide); i++){
            answer++;
        }
        
        return answer;
    }
}