// StringBuilder, String을 활용한 풀이는 시간초과를 해결할 수 없다.
// Stack을 이용하여 빠르게 비교하고 처리한다.
import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        
        for(int i=0; i<array.length; i++){
            // 스택이 비어있는 경우, 비교없이 원소를 추가한다.
            if(stack.isEmpty()){
                stack.push(array[i]);
            }
            else{
                if(stack.peek() == array[i]){
                    stack.pop();
                }
                else{
                    stack.push(array[i]);
                }
            }
        }
        
        if(stack.size() == 0){
            answer = 1;
        }
        
        return answer;
    }
}