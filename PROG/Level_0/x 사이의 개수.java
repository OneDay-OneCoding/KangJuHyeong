import java.util.*;

class Solution {
    public int[] solution(String myString) {
        // Case1. StringTokenizer
        // StringTokenizer는 연속된 구분자간 데이터가 존재하지 않을 경우, 하나의 요소로 인정하지 않는다.
        // StringTokenizer st = new StringTokenizer("x" + myString + "x", "x");
        // int size = st.countTokens();
        
        // Case2. String.split()
        // String 클래스의 split()은 연속된 구분자간 데이터가 존재하지 않아도, 하나의 요소로 인정한다.
        // String 클래스의 split()도 맨끝에 구분자가 아닌 데이터가 존재하지 않으면 구분자를 별도의 요소로 인정하지 않기 때문에, 전처리가 요구된다.
        myString = myString + "xo";
        String[] array = myString.split("x");
        int[] answer = new int[array.length-1];
        for(int i=0; i<array.length-1; i++){
            answer[i] = array[i].length();
        }
        return answer;
    }
}