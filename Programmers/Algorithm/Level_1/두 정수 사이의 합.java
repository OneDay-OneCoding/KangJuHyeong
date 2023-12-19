import java.util.*;

class Solution {
    public long solution(int a, int b) {
        int[] array = new int[2];
        array[0] = a;
        array[1] = b;
        
        Arrays.sort(array);
        long answer = 0;
        
        for(int i=array[0]; i<=array[1]; i++){
            answer += i;
        }
        return answer;
    }
}