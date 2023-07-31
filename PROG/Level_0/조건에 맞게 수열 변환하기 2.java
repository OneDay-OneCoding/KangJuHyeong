import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] before = Arrays.copyOf(arr, arr.length);
        int[] after = Arrays.copyOf(arr, arr.length);
        boolean flag = true;
        int answer = 0;
        
        while(flag){
            for(int i=0; i<before.length; i++){
                if(before[i]>=50 && before[i]%2==0){
                    before[i] = before[i]/2;
                }
                else if(before[i]<50 && before[i]%2!=0){
                    before[i] = before[i]*2 + 1;
                }
            }
            for(int i=0; i<before.length; i++){
                if(before[i] == after[i]){
                    if(i == before.length-1){
                        flag = false;
                    }
                    continue;
                }
                else{
                    after = Arrays.copyOf(before, before.length);
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}