// 첫 번째 행렬의 크기가 (m*n)이고, 두 번째 행렬의 크기가 (n*p)일때
// 결과 행렬은 (m*p)의 크기를 갖게 된다.
// 곱할 수 있는 배열만 주어지므로, 별도의 조건검사는 필요하지 않다.

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        // 첫 번째 행렬의 i번째 행과 두 번째 행렬의 j번째 열 원소의 스칼라 곱이다.
        // a11b11 + .. + a1nb1n ... a11b1p + .. + a1nbnp
        // ..                   ... 
        // am1b11 + .. + amnb1n ... am1b1p + .. + amnbnp
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2[0].length; j++){
                for(int k=0; k<arr2.length; k++){
                    answer[i][j] += (arr1[i][k] * arr2[k][j]); 
                }
            }
        }
        
        return answer;
    }
}