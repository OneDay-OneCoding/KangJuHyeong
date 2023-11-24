import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> queueLeft = new ArrayDeque<>();
        Queue<Integer> queueRight = new ArrayDeque<>();
        long sumLeft = 0;
        long sumRight = 0;
        
        for(int i=0; i<queue1.length; i++){
            queueLeft.add(queue1[i]);
            sumLeft += queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++){
            queueRight.add(queue2[i]);
            sumRight += queue2[i];
        }
        
        while(sumLeft != sumRight){
            if(answer > (queue1.length + queue2.length)*2){
                return -1;
            }
            else{
                if(sumLeft > sumRight){
                    int temp = queueLeft.poll();
                    sumLeft -= temp;
                    queueRight.add(temp);
                    sumRight += temp;
                }
                else if(sumLeft < sumRight){
                    int temp = queueRight.poll();
                    sumRight -= temp;
                    queueLeft.add(temp);
                    sumLeft += temp;
                }
            }
            answer += 1;
        }
        
        return answer;
    }
}