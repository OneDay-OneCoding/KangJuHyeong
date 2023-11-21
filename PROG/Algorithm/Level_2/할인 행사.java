// discount 배열의 길이가 매우 길기 때문에, 10개의 수량이 확보가 되었다면 
// 그 뒤부터는 앞에서 하나 빼고 뒤에서 하나 넣어주는 방식으로 작동해야한다.
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 회원가입 후 10일동안 원하는 제품을 모두 할인 받을 수 있는 날짜의 총 일수
        int answer = 0;
        
        // 원하는 제품별 구매가능한 수량을 나타내는 해시맵
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], 0);
        }
        
        for(int i=0; i<discount.length; i++){
            // 할인 받을 수 있는 항목 개수 통계 작업
            map.putIfAbsent(discount[i], 0);
            
            if(i<10){ // 10일 전에는 별도의 작업없이 해시맵에 넣어준다.
                map.put(discount[i], map.get(discount[i]) + 1);
            }
            else{ // 10일을 넘긴 경우, 맨 앞 날짜의 항목을 1개 빼주고 새로 들어온 날짜의 항목을 1개 추가한다.
                map.put(discount[i-10], map.get(discount[i-10]) - 1);
                map.put(discount[i], map.get(discount[i]) + 1);
            }
            
             // 할인 받을 수 있는 항목 개수가 정현이가 원하는 제품의 수량과 일치하는지 확인하는 작업
            boolean check = true;
            for(int j=0; j<want.length; j++){
                if(map.get(want[j]) >= number[j]){
                    continue;
                }
                else{
                    check = false;
                    break;
                }
            }

            if(check){
                answer += 1;
            }
        }
        
        return answer;
    }
}