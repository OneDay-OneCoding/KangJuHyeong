import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){      
            // STEP1. array의 i번째 원소부터 j번째 원소까지 자른다.
            int[] copy = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            
            // STEP2. array 배열을 오름차순 정렬한다.
            Arrays.sort(copy);
            
            // STEP3. 정렬된 array 배열의 k번째 숫자를 담는다.
            answer[i] = copy[commands[i][2]-1];
        }

        return answer;
    }
}