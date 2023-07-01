class Solution {
    public int[] solution(int l, int r) {
        int[] answer = new int[1];
        answer[0] = -1;

        int count = 0;
        for(int i=l; i<=r; i++){
            String var = Integer.toString(i);
            if(var.matches("5[0|5]*")){
                count++;
            }
        }
        
        if(count!=0){
            answer = new int[count];
            int index = 0;
            for(int i=l; i<=r; i++){
                String var = Integer.toString(i);
                if(var.matches("5[0|5]*")){
                    answer[index++] = i;
                }
            }
        }
        return answer;
    }
}