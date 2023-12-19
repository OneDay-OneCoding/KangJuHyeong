import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] status = new int[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        // 작업 소요 기간을 계산하여 기록한다.
        for(int i=0; i<progresses.length; i++){
            status[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);   
        }
        
        int count = 1;
        int max = status[0];

        for(int i=1; i<status.length; i++){
            if(max >= status[i]){
                count += 1;
                
            }
            else{
                max = Math.max(max, status[i]);
                list.add(count);
                count = 1;
            }
            
            if(i == status.length-1){
                list.add(count);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}