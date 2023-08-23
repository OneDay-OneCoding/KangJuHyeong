class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        char[] array = Integer.toString(x).toCharArray();
        int value = 0;
        
        for(int i=0; i<array.length; i++){
            value += array[i] -'0';
        }
        if(x%value != 0){
            answer = false;
        }
        return answer;
    }
}