import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        char[] array = str.toCharArray();
        int[] transform = new int[array.length];
        
        for(int i=0; i<array.length; i++){
            transform[i] = array[i] - '0';
        }
        
        Integer[] transition = Arrays.stream(transform).boxed().toArray(Integer[]::new);
        Arrays.sort(transition, Collections.reverseOrder());
        
        for(int i=transition.length-1; i>=0; i--){
            answer += Math.pow(10,transition.length-i-1) * transition[i];
        }

        return answer;
    }
}