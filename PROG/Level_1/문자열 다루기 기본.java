class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 || s.length()==6){
            char[] array = s.toCharArray();
            for(int i=0; i<array.length; i++){
                if(Character.isDigit(array[i])){
                    continue;
                }
                else{
                    answer = false;
                    break;
                }
            }
        }
        else{
            answer = false;
        }
        return answer;
    }
}