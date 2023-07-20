class Solution {
    public int solution(String my_string) {
        String[] array = my_string.split("[a-z]|[A-Z]");
        int answer = 0;
        for(int i=0; i<array.length; i++){
            if(!array[i].equals("")){
                answer += Integer.parseInt(array[i]);    
            }
        }
        
        return answer;
    }
}