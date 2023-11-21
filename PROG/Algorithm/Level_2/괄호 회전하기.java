import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 괄호 문자열을 왼쪽으로 회전한다.
        int size = s.length();
        for(int i=0; i<size; i++){
            String str = s.substring(i,size) + s.substring(0,i);
            
            // 회전된 괄호 문자열이 올바른 괄호 문자열인지 검사한다.
            // 배열로 카운팅해서 검사하는 방법은 쓰지 말자.. 스택으로 구현하는게 정확하다.
            // -> 반례) "([{)}]" -> "0"
            if(check(str)){
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public boolean check(String s){
        Stack<String> stack = new Stack<>(); // 괄호 검사용 스택
        String[] str = s.split("");
        
        for(int i=0; i<str.length; i++){
            // 여는 괄호는 스택에 넣는다.
            if(str[i].equals("(") || str[i].equals("{") || str[i].equals("[")){
                stack.push(str[i]);
            }
            // 닫는 괄호를 받았으나, 짝에 해당하는 여는 괄호가 없는 경우 에러이다.
            else{
                if(str[i].equals(")")){
                    if(stack.size()>0 && stack.peek().equals("(")){
                        stack.pop();
                    }  
                    else{
                        return false;
                    }
                }
                else if(str[i].equals("}")){
                    if(stack.size()>0 && stack.peek().equals("{")){
                        stack.pop();
                    }  
                    else{
                        return false;
                    }
                }
                else if(str[i].equals("]")){
                    if(stack.size()>0 && stack.peek().equals("[")){
                        stack.pop();
                    }  
                    else{
                        return false;
                    }
                }
            }
        }
        
        if(stack.size() == 0){
            return true;   
        }
        
        return false;
    }
    
    /*
    public boolean check(String s){
        // 소괄호 () : 0, 중괄호 {} : 1, 대괄호 [] : 2
        int[][] count = new int[3][2];
        String[] array = s.split("");
        
        for(int i=0; i<array.length; i++){
            switch(array[i]){
                case "(":
                    count[0][0] += 1;
                    break;
                case ")":
                    if(count[0][0] <= count[0][1]){
                        return false;
                    }
                    else{
                        count[0][1] += 1;
                    }
                    break;
                case "{":
                    count[1][0] += 1;
                    break;
                case "}":
                    if(count[1][0] <= count[1][1]){
                        return false;
                    }
                    else{
                        count[1][1] += 1;
                    }
                    break;
                case "[":
                    count[2][0] += 1;
                    break;
                case "]":
                    if(count[2][0] <= count[2][1]){
                        return false;
                    }
                    else{
                        count[2][1] += 1;
                    }
                    break;
            }    
        }
        
        // 모든 괄호 짝이 일치하는지 확인한다.
        for(int i=0; i<count.length; i++){
            for(int j=0; j<count[i].length; j++){
                if(count[i][0] != count[i][1]){
                    return false;
                }
            }
        }
        
        return true;
    }
    */
}