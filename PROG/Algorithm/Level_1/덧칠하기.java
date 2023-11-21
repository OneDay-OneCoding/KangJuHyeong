class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int index = 0;
        int record = index;
        
        while(true){
            if(index == section.length){
                break;
            }
            else{
                int check = 0;
                for(int i=index; i<section.length; i++){
                    int area = section[index]+m-1;
                    if(area >= section[i]){
                        check = i+1;
                    }
                    else{
                        break;
                    }
                }
                if(check == 0){
                    index++;    
                }
                else{
                    index = check;    
                }
                
                answer++;
            }
        }
        
        return answer;
    }
}