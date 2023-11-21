import java.util.*;

class Solution {
    // 연속된 4개의 인덱스가 햄버거 재료와 일치할때 리스트에서 해당 요소들을 제거하고
    // 인덱스는 다시 처음으로 돌아가서 해당 작업을 반복한다. 
    // 인덱스가 ingredient[] 배열의 마지막에 도달했음에도 햄버거와 일치하지 않는 경우 반복을 종료한다.
    // -> 처음으로 돌아가니까 시간 초과 엄청 뜬다.. 실패한 로직
    // -> 개선 로직으로 스택을 활용하고, ingredient 배열 크기만큼만 반복한다.
    
    // 빵, 야채, 고기, 빵 -> 1, 2, 3, 1
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] hamburger = {1, 2, 3, 1};
        
        for(int i=0; i<ingredient.length; i++){
            stack.push(ingredient[i]);
            if(stack.size() >= 4){
                boolean check = true;
                
                for(int j=4; j>0; j--){
                    if(stack.get(stack.size()-j) == hamburger[4-j]){
                        continue;
                    }
                    else{
                        check = false;
                    }
                }
                
                if(check){
                    answer++;
                    for(int j=0; j<4; j++){
                        stack.pop();
                    }
                }
            }
        }
        
        return answer;
    }
}