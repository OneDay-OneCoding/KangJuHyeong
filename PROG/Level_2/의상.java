import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 의상 종류별로 clothes 배열의 의상들을 분류한다.
        // 의상의 수는 30개 이하로, 최대 30 종류의 의상이 존재할 수 있다.
        // 해당 종류의 의상을 입지 않는 경우를 고려하고, 모든 종류의 의상을 입지 않는 것은 제외해야한다.
        // 1종류 A개 -> (A + 1) - 1
        // 2종류 B개 -> (A + 1) * (B + 1) - 1
        // N종류 M개 -> (A + 1) * (B + 1) * (C + 1) ... * (M + 1) - 1
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            map.putIfAbsent(clothes[i][1], new ArrayList<String>());
            map.get(clothes[i][1]).add(clothes[i][0]);
        }
        
        Iterator<Map.Entry<String, ArrayList<String>>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, ArrayList<String>> entry = iter.next();
            answer *= (entry.getValue().size() + 1);
        }
        answer -= 1;
        
        return answer;
    }
}