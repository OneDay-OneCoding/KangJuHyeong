// 최솟값 또는 최댓값을 빠르게 탐색하기 위해 Heap을 이용한다.
// Java의 Collections에는 Heap이 없으므로, Primary Queue로 최소 힙을 구현한다.
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++){
            heap.add(scoville[i]);
        }
        
        while(true){
            if(check(heap, K)){
                break;
            }
            // 모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우
            else if(heap.size()==1){
                answer = -1;
                break;
            }
            else{
                int first = heap.poll(); // 가장 맵지 않은 음식의 스코빌 지수
                int second = heap.poll(); // 두 번째로 맵지 않은 음식의 스코빌 지수
                int mix = first + (second * 2); // 섞은 음식의 스코빌 지수
                answer += 1; // 섞은 횟수를 추가한다.
                
                heap.add(mix);
            }
        }
        
        return answer;
    }
    
    // 매개변수로 전달받은 Heap의 전체 스코빌지수가 K이상인지 검사하는 함수
    public boolean check(PriorityQueue<Integer> h, int k){
        boolean c = true;
        Iterator iter = h.iterator();
        
        while(iter.hasNext()){
            int compare = (int)iter.next();
            if(compare >= k){
                continue;
            }
            else{
                c = false;
                break;
            }
        }
        
        return c;
    }
}