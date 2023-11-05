import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        // answer[0] = 가장 먼저 탈락하는 사람의 번호
        // answer[1] = 몇 번째 차례에 탈락하는지에 대한 순서
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        
        for(int i=1; i<words.length; i++){
            // 이전 사람이 말했던 단어의 마지막 문자
            String before = words[i-1].substring(words[i-1].length()-1, words[i-1].length());
            
            // 현재 사람이 말하는 단어는 시작 문자
            String after = words[i].substring(0, 1);
            
            // 두 문자가 일치하는 경우, 이전에 등장했던 단어인지 검사한다.
            if(before.equals(after) && !set.contains(words[i])){
                set.add(words[i]);
            }
            
            // 두 문자가 일치하지 않는 경우, 끝말잇기를 종료한다.
            else{
                answer[0] = (i%n) + 1; // 끝말잇기에 참여하는 사람의 번호
                answer[1] = (i/n) + 1; // 끝말잇기가 진행된 순서
                break;
            }
        }

        return answer;
    }
}