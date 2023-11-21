class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] array = s.toCharArray();
        int index = 0;
        int same = 0;
        int other = 0;
                
        for(int i=index; i<array.length; i++){
            // 첫 번째 글자
            char word = array[index];
            
            if(array[i] == word){
                same++;
            }
            else{
                other++;
            }

            if(same == other){
                same = 0;
                other = 0;
                index = i+1;
                answer++;
            }
            else if(index == array.length-1){
                answer++;
            }
            else if(i == array.length-1){
                answer++;
            }
        }
        
        return answer;
    }
}