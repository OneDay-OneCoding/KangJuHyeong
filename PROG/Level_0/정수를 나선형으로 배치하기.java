// 우 -> [0][0], [0][1], [0][2], [0][3] --> [1][1] ...
// 하 -> [1][3], [2][3], [3][3]
// 좌 -> [3][2], [3][1], [3][0]
// 상 -> [2][0], [1][0]
// 우 -> [1][1], [1][2]
// 하 -> [2][2]
// 좌 -> [3][1]

class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int number = 1;
        int rotation = 1;
        int round = 0;
        
        while(true){
            if(n%2 == 0){
                if(number-1 == n*n){
                    break;    
                }
                else{
                    switch(rotation){
                        case 1: // 우
                            for(int i=round; i<(n-1-round); i++){
                                answer[round][i] = number++;
                            }
                            rotation = 2;
                            break;

                        case 2: // 하
                            for(int i=round; i<(n-1-round); i++){
                                answer[i][n-1-round] = number++;
                            }
                            rotation = 3;
                            break;

                        case 3: // 좌
                            for(int i=(n-1-round); i>round; i--){
                                answer[n-1-round][i] = number++;
                            }
                            rotation = 4;
                            break;

                        case 4: // 상
                            for(int i=(n-1-round); i>round; i--){
                                answer[i][round] = number++;
                            }
                            rotation = 1;
                            round++;    
                            break;
                    }  
                }
            }    
            else if(n%2==1){
                if(number == n*n){
                    answer[n/2][n/2] = number++;
                    break;    
                }
                else{
                    switch(rotation){
                        case 1: // 우
                            for(int i=round; i<(n-1-round); i++){
                                answer[round][i] = number++;
                            }
                            rotation = 2;
                            break;

                        case 2: // 하
                            for(int i=round; i<(n-1-round); i++){
                                answer[i][n-1-round] = number++;
                            }
                            rotation = 3;
                            break;

                        case 3: // 좌
                            for(int i=(n-1-round); i>round; i--){
                                answer[n-1-round][i] = number++;
                            }
                            rotation = 4;
                            break;

                        case 4: // 상
                            for(int i=(n-1-round); i>round; i--){
                                answer[i][round] = number++;
                            }
                            rotation = 1;
                            round++;    
                            break;
                    }  
                }
            }
        }
        
        return answer;
    }
}