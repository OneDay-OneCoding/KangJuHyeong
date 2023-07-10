class Solution {
    public String[] solution(String my_str, int n) {
        int count = (int)Math.ceil((double)my_str.length()/n);
        int index = 0;
        String[] answer = new String[count];
        
        for(int i=0; i<count; i++){
            if(index+n >= my_str.length()){
                answer[i] = my_str.substring(index, my_str.length());
            }
            else{
                answer[i] = my_str.substring(index, index+n);
                index += n;
            }
        }
        return answer;
    }
}