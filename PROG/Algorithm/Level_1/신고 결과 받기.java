import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 유저별 신고횟수를 기록하기 위해 Map을 이용한다.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], 0);
        }
        
        // 한 유저의 동일한 신고 횟수를 1회로 처리하기 위해, Set을 이용한다.
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<report.length; i++){
            set.add(report[i]);
        }
        
        // 유저별로 유저가 신고한 사용자 목록을 저장한다.
        HashMap<String, HashSet<String>> reportList = new HashMap<>();
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            String s = (String)iter.next();
            String reporter = s.split(" ")[0]; // 신고자
            String reported = s.split(" ")[1]; // 피신고자
            
            reportList.putIfAbsent(reporter, new HashSet<String>(){{
                add(reported);
            }});
            reportList.get(reporter).add(reported);
            map.put(reported, map.get(reported)+1);
        }
        
        // 신고횟수가 k번 이상 누적되어 정지된 사용자들의 목록을 추출한다.
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        ArrayList<String> stop = new ArrayList<>();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            if(entry.getValue() >= k){
                stop.add(entry.getKey());
            }
        }
        
        // 정지된 사용자 목록이 저장되어있는 배열
        String[] stopArray = new String[stop.size()];
        for(int i=0; i<stop.size(); i++){
            stopArray[i] = stop.get(i);
        }
        
        // 유저가 신고한 사용자와 정지된 사용자를 대조하여 일치횟수를 카운팅한다.
        for(int i=0; i<answer.length; i++){
            try{
                HashSet<String> list = reportList.get(id_list[i]);
                for(int j=0; j<stopArray.length; j++){
                    if(list.contains(stopArray[j])){
                        answer[i]++;
                    }    
                }
            }catch(NullPointerException e){
                continue;
            }
        }
        
        return answer;
    }
}