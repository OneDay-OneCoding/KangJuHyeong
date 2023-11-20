/*
#TC2. 총 실행시간 : 21초
"Jeju" <- [] Cache Miss +5
"Pangyo" <- ["Jeju"] Cache Miss +5
"Seoul" <- ["Jeju", "Pangyo"] Cache Miss +5
"Jeju" <- ["Jeju", "Pangyo", "Seoul"] Cache Hit +1
"Pangyo" <- ["Pangyo", "Seoul", "Jeju"] Cache Hit +1
"Seoul" <- ["Seoul", "Jeju","Pangyo"] Cache Hit +1
"Jeju" <- ["Jeju", "Pangyo", "Seoul"] Cache Hit +1
"Pangyo" <- ["Pangyo", "Seoul", "Jeju"] Cache Hit +1
"Seoul" <- ["Seoul", "Jeju", "Pangyo"] Cache Hit +1
*/
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // LRU 알고리즘을 적용하기 위해 ArrayList를 사용한다.
        // 큐는 특정 원소를 제거하는 함수가 지원되지 않기때문에 부적절하다.
        ArrayList<String> list = new ArrayList<>();
        
        for(int i=0; i<cities.length; i++){
            // 도시 이름은 대소문자를 구분하지 않는다.
            String city = cities[i].toUpperCase();
            
            // 캐시 기록을 수정하기 전, 캐시 히트 여부부터 검증한다.
            if(list.contains(city)){
                answer += 1; // Cache Hit +1
                
                // 캐시 히트인 경우, 해당 도시 기록을 제거하고 맨 뒤에 추가한다.
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).equals(city)){
                        list.remove(j);
                        break;
                    }
                }
                
                // 맨 뒤에 가장 최근 도시 기록 추가
                if(cacheSize > 0){
                    list.add(city);    
                }
            }
            else{
                answer += 5; // Cache Miss +5
                
                // 캐시 기록에 대한 삭제는 큐가 가득 찼을때만 진행한다.
                if(list.size() >= cacheSize && list.size()>0){
                    list.remove(0); // 맨 앞의 도시 기록 제거    
                }
                
                // 맨 뒤에 가장 최근 도시 기록 추가
                if(cacheSize > 0){
                    list.add(city);    
                }
            } 
        }
        
        return answer;
    }
}