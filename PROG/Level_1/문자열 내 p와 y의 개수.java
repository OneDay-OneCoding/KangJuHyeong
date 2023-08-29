class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        char[] array = s.toCharArray();
        boolean answer = false;
        int countP = 0;
        int countY = 0;
        
        for(int i=0; i<array.length; i++){
            if(array[i] == 'p'){
                countP++;
            }
            else if(array[i] == 'y'){
                countY++;
            }
        }
        
        if(countP == countY){
            answer = true;
        }

        return answer;
    }
}