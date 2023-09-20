import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[] array = new String[strings.length];
        
        // 해당 인덱스의 문자를 단어의 맨 앞에 붙여 정렬한다.
        // 같은 문자를 가진 인덱스여도, 자연스럽게 사전순으로 정렬이 가능해진다.
        for(int i=0; i<array.length; i++){
            array[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(array);
        
        for(int i=0; i<array.length; i++){
            answer[i] = array[i].substring(1, array[i].length());
        }
        return answer;
    }
}