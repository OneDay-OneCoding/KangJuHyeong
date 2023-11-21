import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        // 선수 이름으로 순위를 찾아내는 자료구조
        HashMap<String, Integer> name = new HashMap<>();
        
        // 순위로 선수 이름을 찾아내는 자료구조
        HashMap<Integer, String> rank = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            name.put(players[i], i);
            rank.put(i, players[i]);
        }
        
        // map에 저장된 원소를 선수 이름을 키 값으로 찾은 다음
        // 해당 원소의 밸류 값에 해당하는 순위와 앞 순위 원소의 순위를 조정한다.
        for(int i=0; i<callings.length; i++){
            // "kai"를 호명한 경우, kai를 현재 순위의 앞순위로 변경한다.
            // "kai"의 앞 순위에 해당하는 "poe"가 target이 되므로 임시저장한다.
            String target = rank.get(name.get(callings[i])-1);
            rank.put(name.get(callings[i])-1, callings[i]);
            rank.put(name.get(callings[i]), target);
            name.put(callings[i], name.get(callings[i])-1);
            name.put(target, name.get(target)+1);
        }
        
        for(int i=0; i<rank.size(); i++){
            answer[i] = rank.get(i);
        }
        
        return answer;
    }
}