import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        HashMap<String, Integer> termMap = new HashMap<>();
        
        // Key는 약관 종류로, Value는 유효기간으로 매핑하여 저장한다.
        for(int i=0; i<terms.length; i++){
            String type = terms[i].split(" ")[0]; // 약관 종류
            int term = Integer.parseInt(terms[i].split(" ")[1]); // 유효기간
            termMap.put(type, term);
        }
        
        // 파기해야 할 개인정보 명단
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<privacies.length; i++){
            String date = privacies[i].split(" ")[0]; // 개인정보 수집 일자
            String type = privacies[i].split(" ")[1]; // 약관 종류
            int term = termMap.get(type);
            
            // 개인정보를 보관한 달 수가 유효기간을 초과한 경우
            if(calc(today, date) >= term){
                list.add((i+1));
            }
        }
        
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        
        return answer;
    }
    
    // 오늘 날짜(today)에서 개인정보 수집 일자(privacies.split("")[0])를 뺀 기간을 계산한 다음, 달로 나눠서 반환한다.
    public int calc(String t, String d){
        // 구분자가 특수문자인 경우, \\를 포함해야 정상적으로 인식된다.
        int ty = Integer.parseInt(t.split("\\.")[0]);
        int tm = Integer.parseInt(t.split("\\.")[1]);
        int td = Integer.parseInt(t.split("\\.")[2]);
        int today = (ty * 12 * 28) + (tm * 28) + td;
        
        int dy = Integer.parseInt(d.split("\\.")[0]);
        int dm = Integer.parseInt(d.split("\\.")[1]);
        int dd = Integer.parseInt(d.split("\\.")[2]);
        int day = (dy * 12 * 28) + (dm * 28) + dd;
        
        return (today - day)/28;
    }
}