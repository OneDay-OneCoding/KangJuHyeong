import java.util.*;

class Solution {
    char[] op;
    char[] input;
    boolean[] visited;
    long answer;
    
    public long solution(String expression) {
        HashSet<Character> set = new HashSet<>();
        char[] array = expression.toCharArray();
        for(int i=0; i<array.length; i++){
            if(array[i] == '*' || array[i] == '+' || array[i] == '-'){
                set.add(array[i]);
            }    
        }
        
        op = new char[set.size()];
        input = new char[op.length];
        visited = new boolean[op.length];
        Iterator iter = set.iterator();
        int idx = 0;
        while(iter.hasNext()){
            op[idx++] = (char)iter.next();
            // System.out.println(input[idx-1]);
        }
        // System.out.println(set.size());
        
        perm(0, expression);
        return answer;
    }
    
    public void perm(int cnt, String expression){
        if(cnt==op.length){
            ArrayList<Long> number = new ArrayList<>();
            ArrayList<Character> operator = new ArrayList<>(); 
            String[] array = expression.split("[*|+|-]");
            
            // 숫자를 토큰별로 쪼개어 넣는다.
            for(int i=0; i<array.length; i++){
                number.add(Long.parseLong(array[i]));
            }
            
            // 연산자를 토큰별로 쪼개어 넣는다.
            char[] opArray = expression.toCharArray();
            for(int i=0; i<opArray.length; i++){
                if(opArray[i] == '*' || opArray[i] == '+' || opArray[i] == '-'){
                    operator.add(opArray[i]);
                }    
            }
            
            for(int i=0; i<input.length; i++){
                // 우선순위에 해당하는 연산자 먼저 계산하는 로직
                for(int j=0; j<operator.size(); j++){
                    if(input[i] == operator.get(j)){
                        switch(input[i]){
                            case '+':
                                number.set(j, number.get(j) + number.get(j+1));
                                break;
                            case '-':
                                number.set(j, number.get(j) - number.get(j+1));
                                break;
                            case '*':
                                number.set(j, number.get(j) * number.get(j+1));
                                break;
                        }
                        number.remove(j+1);
                        operator.remove(j);
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(number.get(0)));
        }
        else{
            for(int i=0; i<op.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    input[cnt] = op[i];
                    perm(cnt+1, expression);
                    visited[i] = false;
                }
            }
        }
    }
}