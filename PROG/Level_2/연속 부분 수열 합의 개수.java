import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        
        // 연속 부분 수열의 합은 중복이 허용되지 않는 Set에 저장한다.
        HashSet<Integer> set = new HashSet<>();
        
        // 수열에 포함되는 원소의 개수만큼 반복한다. (1개 ~ N개)
        for(int i=1; i<=elements.length; i++){
            // 연속 부분 수열이 배열의 범위를 초과하지 않는 경우
            // 반복 종료시점 : i=1 -> j=N, i=2 -> j=1, i=3 -> j=2
            for(int j=0; j<=elements.length-i; j++){
                int sum = 0;
                for(int k=j; k<j+i; k++){
                    sum += elements[k];
                }
                set.add(sum);
            }
            
            // 연속 부분 수열이 배열의 범위를 초과하는 경우
            // (연속 부분 수열의 크기 - 1)만큼 배열의 범위를 초과한다.
            int count = 0;
            int index = elements.length-i+1;
            while(true){
                if(count == i-1){
                    break;
                }
                else{
                    int sum = 0;
                    for(int j=0; j<i; j++){
                        if(count+index+j > elements.length-1){
                            sum += elements[(count+index+j)%elements.length];    
                        }
                        else{
                            sum += elements[count+index+j];
                        }
                    }
                    set.add(sum);
                    count += 1;
                }
            }
        }
        answer = set.size();
        
        return answer;
    }
}