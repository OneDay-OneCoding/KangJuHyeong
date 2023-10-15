import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> r = new ArrayList<>();
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length; i++){
            l.add(lost[i]);
        }
        
        for(int i=0; i<reserve.length; i++){
            r.add(reserve[i]);
        }
        
        // 테스트케이스 3번, 5번, 7번, 12번, 24번에 대한 로직(l.get(i) == r.get(j))
        // -> 여벌 체육복을 가져온 학생이 체육복을 도난당한 경우
        // -> lost 배열과 reserve 배열에 동일한 학생이 포함될 수 있다.
        // 이때, 여벌 체육복을 가져왔지만 도난당한 학생은 타인에게 체육복을 빌려줄 수 없으므로 먼저 제거한다.
        for(int i=0; i<l.size(); i++){
            for(int j=0; j<r.size(); j++){
                if(l.get(i) == r.get(j)){
                    answer += 1;
                    l.remove(i--);
                    r.remove(j--);
                    break;
                }    
            }
        }
        
        for(int i=0; i<l.size(); i++){
            for(int j=0; j<r.size(); j++){
                if(l.get(i)-1 == r.get(j) || l.get(i)+1 == r.get(j)){
                    answer += 1;
                    l.remove(i--);
                    r.remove(j--);
                    break;
                }    
            }
        }
        
        return answer;
    }
}