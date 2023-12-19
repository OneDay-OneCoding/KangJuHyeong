/* 
우선순위 숫자가 클수록 우선순위가 높다!
B C D <- A를 꺼낸다.
B C D A <- A를 다시 집어넣는다.
C D A <- B를 꺼낸다.
C D A B <- B를 다시 집어넣는다.
D A B <- C를 꺼내고, 우선순위가 더 높은 프로세스가 없으므로 실행한다. [C]
A B <- D를 꺼내고 실행한다.[C D]
B <- A를 꺼내고 실행한다.[C D A]
<- B를 꺼내고 실행한다.[C D A B]
*/

import java.util.*;

class Solution { 
    public int solution(int[] priorities, int location) {
        // 큐에 프로세스별 우선순위를 넣은 다음, 최댓값을 가진 프로세스의 인덱스를 찾아낸다.
        // 우선순위가 동일한 프로세스들이 존재하므로 클래스를 별도로 만든다.
        Queue<Process> queue = new ArrayDeque<>();
        ArrayList<Process> list = new ArrayList<>();
        int answer = 0;
        
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Process(i, priorities[i]));
            list.add(new Process(i, priorities[i]));
        }
        
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            
            // 큐의 우선순위 중 최댓값을 구한다.  
            for(int i=0; i<list.size(); i++){
                max = Math.max(max, list.get(i).priority);
            }
            
            Process p = queue.poll();
            list.remove(0);
            if(p.priority == max){
                answer += 1;
                if(p.index == location){
                    break;
                }
            }
            else{
                queue.offer(p);
                list.add(p);
            }
        }
        
        return answer;
    }
    
}

class Process{
    int index;
    int priority;
    
    public Process(int i, int p){
        index = i;
        priority = p;
    }
}