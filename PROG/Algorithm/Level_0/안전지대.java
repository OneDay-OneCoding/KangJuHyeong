class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] delta = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 1){
                    for(int k=0; k<delta.length; k++){
                        int dy = i + delta[k][0];
                        int dx = j + delta[k][1];
                        
                        if(dy >=0 && dx >=0 && dy < board.length && dx < board[i].length){
                            if(board[dy][dx]!=1){
                                board[dy][dx] = 2;
                            }                
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
}