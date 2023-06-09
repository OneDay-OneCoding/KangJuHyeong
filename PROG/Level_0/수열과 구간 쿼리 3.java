class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0; i<queries.length; i++){
            int firstIndex = queries[i][0];
            int lastIndex = queries[i][1];
            int temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp; 
        }
        return arr;
    }
}