class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        
        // CASE1. 행의 수와 열의 수가 같으면 매개변수 배열을 그대로 반환한다.
        if(arr.length == arr[0].length){
            answer = arr;
        }
        
        // CASE2. 행의 수가 열의 수보다 크다면, 각 행의 끝에 원소를 추가한다.
        else if(arr.length > arr[0].length){
            answer = new int[arr.length][arr.length];
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    answer[i][j] = arr[i][j];
                }
            }
        }
        
        // CASE3. 행의 수가 열의 수보다 작다면, 0으로 구성된 행을 추가한다.
        else if(arr.length < arr[0].length){
            answer = new int[arr[0].length][arr[0].length];
            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    answer[i][j] = arr[i][j];
                }
            }
        }
    
        return answer;
    }
}