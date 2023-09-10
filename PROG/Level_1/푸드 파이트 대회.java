class Solution {
    public String solution(int[] food) {
        String answer = "";
        int size = 1;
        
        for(int i=1; i<food.length; i++){
            if(food[i]%2 == 1){
                food[i] -= 1;
                if(food[i] == 0){
                    food[i] = -1;
                }
            }
            if(food[i] != -1){
                size += food[i];    
            }
        }
        
        char[] array = new char[size];
        for(int i=0; i<array.length; i++){
            array[i] = '0';
        }
        
        int startIndex = 0;
        int endIndex = size-1;
        
        for(int i=1; i<food.length; i++){
            while(true){
                if(food[i] == 0 || food[i] == -1){
                    break;
                }
                else{
                    array[startIndex++] = Character.forDigit(i, 10);
                    array[endIndex--] = Character.forDigit(i, 10);
                    food[i] -= 2;
                }
            }
        }
        answer = new String(array);
        
        return answer;
    }
}