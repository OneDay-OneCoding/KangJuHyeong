import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // 진열된 모든 보석의 종류 개수를 나타내는 category(Set을 이용하여 중복제거)
        int category = new HashSet<>(Arrays.asList(gems)).size();
       
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간의 길이 length
        int length = Integer.MAX_VALUE, start = 0;
        
        // 구간을 이동하면서 보석 종류에 따른 개수를 표현할 HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // end값을 움직이면서 모든 종류의 보석을 적어도 1개 이상 포함하는 구간의 끝을 알아낸 뒤,
        // start값을 움직이면서 중복된 보석을 1개씩 제외시키며 전진한다.
        for(int end=0; end<gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            // start에 위치한 보석의 개수가 1개를 초과할 경우, start를 한칸 전진시키고 map에서 1개를 뺀다.
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start += 1;
            }
            
            // map에 모든 종류의 보석이 최소 1개이상 들어있고 length의 길이가 구간의 길이보다 커 갱신이 필요한 경우
            if(category == map.size() && length > (end-start)){
                length = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }
        
        return answer;
    }
}