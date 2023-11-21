class Solution {
    public int[] solution(int n, long left, long right) {
        long size = right-left+1;
        int[] answer = new int[(int)size];
        
        // 배열을 구성하지 말고 수식으로 해결해야한다.
        // -> [x,y] = Math.max(x,y)
        
        // left, right와 같은 index가 주어졌을 때, 
        // 해당 인덱스가 (n*n) 배열에서 어느 좌표인지 역추적해야한다.
        
        // n = 3일때의 인덱스 배치도
        // -> 0 : (0,0)  1 : (0,1)  2 : (0,2)
        // -> 3 : (1,0)  4 : (1,1)  5 : (1,2)
        // -> 6 : (2,0)  7 : (2,1)  8 : (2,2)
        long count = left;
        
        // 0에서부터 시작해서 right까지 가면 O(n^2)의 시간복잡도로 시간초과가 발생할 수 있다.
        // left에서부터 시작해서 right까지 가면 최대 10^5까지만 연산하게된다.
        while(true){
            if(count > right){
                break;
            }
            else{
                answer[(int)(count-left)] = Math.max((int)(count / n),(int)(count % n)) + 1;
                count += 1;      
            }
        } 
        
        return answer;
    }
}

/*
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right-(int)left+1];
        
        // (10^7) * (10^7) -> 메모리 폭발
        // 애니메이션과 같이 배열로 먼저 값을 넣어준 다음 분리하는 방식은 적절하지 않다.
        int[][] array = new int[n][n];
        
        // [0,0][0,1][0,2]
        // [1,0][1,1][1,2]
        // [2,0][2,1][2,2]
        for(int i=0; i<n; i++){
           array[0][i] = i+1;
            
           // 행 및 열 채우기 
           for(int j=0; j<=i; j++){
               array[i][j] = i+1;
               array[j][i] = i+1;
           }  
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i*n+j>=left && i*n+j<=right){
                    answer[i*n+j-(int)left] = array[i][j];
                }
            }
        }
        
        return answer;
    }
}
*/