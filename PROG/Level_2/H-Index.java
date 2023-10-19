import java.util.*;

class Solution {    
    public int solution(int[] citations) {
        int answer = 0;

        // H편 이상 인용된 논문은 개수도 H편을 넘어야하지만, 
        // 나머지 논문들은 H번 이하로만 인용되면 개수는 무관하다.
        Arrays.sort(citations);
        
        // 해당 인덱스의 값이 H의 값을 넘긴다면, 그것이 곧바로 H-Index의 최댓값이 된다.
        for(int i=0; i<citations.length; i++){
            // 해당 인덱스에서 가질 수 있는 H-Index의 최댓값(H번 이상 인용된 논문의 개수)
            // 즉, 인용 횟수가 citations[i] 이상인 논문들이 (citations.length - i)편 있음을 의미한다.
            // 따라서, 문제 풀이의 관건은 i를 0부터 이동시키면서 인용 횟수가 H번을 넘는 인덱스가 있는지를 찾아내야한다.
            int h = citations.length - i;
            
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}