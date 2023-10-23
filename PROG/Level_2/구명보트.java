// ArrayList에 사람들의 몸무게를 기록한 다음, 정렬하여 맨앞(최솟값)과 맨뒤(최댓값)에서 꺼내온다.
// ArrayList로 구현한 결과, 효율성 테스트케이스 1번에서 시간 초과가 발생하므로, 배열 포인터로 재구현한다.

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int min = 0; // 최솟값 포인터
        int max = people.length - 1; // 최댓값 포인터
        
        while(true){
            // 요구조자가 1명인 경우
            if(min > max){
                break;
            }
            else{
                // 요구조자가 2명 이상인 경우
                // 가장 가벼운 사람과 가장 무거운 사람이 구명보트에 함께 탑승하는 경우
                if(people[min] + people[max] <= limit){
                    min += 1;
                    max -= 1;
                }
                // 가장 무거운 사람만 구명보트에 혼자 탑승하는 경우
                else{
                    max -= 1;
                }
            }
            answer += 1;
        }
        
        return answer;
    }
}

/*
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0; i<people.length; i++){
            list.add(people[i]);
        }
        Collections.sort(list);
        
        while(true){
            if(list.size() == 0){
                break;
            }
            else{
                // 요구조자가 2명 이상인 경우
                if(list.size() > 1){
                    // 가장 가벼운 사람과 가장 무거운 사람이 구명보트에 함께 탑승하는 경우
                    if(list.get(0) + list.get(list.size()-1) <= limit){
                        list.remove(0);
                        list.remove(list.size()-1);
                    }
                    // 가장 무거운 사람만 구명보트에 혼자 탑승하는 경우
                    else{
                        list.remove(list.size()-1);
                    }
                }
                // 요구조자가 1명인 경우
                else{
                    list.remove(0);
                }
                answer += 1;
            }
        }
        
        return answer;
    }
}
*/