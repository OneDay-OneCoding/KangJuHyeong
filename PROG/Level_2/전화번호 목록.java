import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], i);    
        }
        
        for(int i=0; i<phone_book.length; i++){
            // 비교기준의 부분문자열이 존재하는지 확인한다.
            // phone_book의 원소를 다른 문자열과 비교하지말고
            // phone_book의 원소에 대해 부분문자열이 map에 존재하는지 확인한다.
            // "119" -> "1", "11"이 map에 존재하는지 확인
            // "1195524421" -> "1", "11", "119"..이 map에 존재하는지 확인
            String target = phone_book[i];
            for(int j=1; j<target.length(); j++){
                if(map.containsKey(target.substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}