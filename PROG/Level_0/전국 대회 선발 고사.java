class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        int[] join = new int[3];
        
        for(int i=0; i<join.length; i++){
            int index = -1;
            int value = Integer.MAX_VALUE;
            
            for(int j=0; j<rank.length; j++){
                if(rank[j] != 0){
                    if(attendance[j]){
                        if(value > rank[j]){
                            index = j;
                            value = rank[j];
                        }
                    }
                }
            }
            join[i] = index;
            rank[index] = 0;
        }
        
        answer = join[0] * 10000 + join[1] * 100 + join[2];
        return answer;
    }
}