// k와 tangerine의 제한사항에 따르면, 중복조합으로 풀이할 문제는 아닌 것 같다.
// 크기별로 귤의 개수를 저장한 다음, 개수가 많은 순서대로 담아서 해결한다.
// 몇 번 귤을 몇개 담는지 구분하는것은 중요하지 않다. 몇 종류만 담았는지 알면 된다.
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            queue.add(map.get(iter.next()));
        }
        
        iter = queue.iterator();
        int count = 0;
        while(iter.hasNext()){
            if(count >= k){
                break;
            }
            else{
                count += queue.poll();
                answer += 1;
            }
        }
        
        return answer;
    }
}