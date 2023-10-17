class Solution {
    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        
        // size[i][0]에 더 큰 값을 배치하고, size[i][1]에 더 작은 값을 배치하여 정렬한다.
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        
        int width = 0;
        int height = 0;
        for(int i=0; i<sizes.length; i++){
            width = Math.max(sizes[i][0], width);
            height = Math.max(sizes[i][1], height);
        }
        answer = width * height;
            
        return answer;
    }
}