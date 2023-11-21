class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0], b = slicer[1], c = slicer[2];
        
        switch(n){
            case 1:
                answer = new int[b+1];
                for(int i=0; i<answer.length; i++){
                    answer[i] = num_list[i];
                }
                break;
            case 2:
                answer = new int[num_list.length-a];
                for(int i=0; i<answer.length; i++){
                    answer[i] = num_list[a+i];
                }
                break;
            case 3:
                answer = new int[b-a+1];
                for(int i=0; i<answer.length; i++){
                    answer[i] = num_list[a+i];
                }
                break;
            case 4:
                answer = new int[(b-a)/c+1];
                for(int i=0; i<answer.length; i++){
                    answer[i] = num_list[a+i*c];
                }
                break;
        }
        return answer;
    }
}