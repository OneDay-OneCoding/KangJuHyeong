// #TC1.
// 0 0 0 0 0
// 0 0 1 0 3
// 0 2 5 0 1
// 4 2 4 4 2
// 3 5 1 3 1

// 4 3 1 1 3 2 4 -> 1 1 3 3 (4개)
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<>();
        
        for(int i=0; i<moves.length; i++){
            int target = moves[i] - 1;
            int item = -1;
            for(int j=0; j<board.length; j++){
                if(board[j][target] == 0){
                    continue;
                }
                else{
                    item = board[j][target];
                    board[j][target] = 0;
                    break;
                }
            }
            
            // 테스트케이스 1번, 2번에 대한 로직
            // 하나의 층에 대해 모두 탐색했지만 집게가 아무것도 집지 못한 경우
            // basket에 대한 비교 및 추가 작업을 중단한다.
            if(item == -1){
                continue;
            }
               
            if(basket.size() == 0){
                basket.add(item);    
            }
            else{
                if(basket.get(basket.size()-1) == item){
                    answer += 2;
                    basket.remove(basket.size()-1);
                }
                else{
                    basket.add(item);   
                }
            }
        }
                    
        return answer;
    }
}