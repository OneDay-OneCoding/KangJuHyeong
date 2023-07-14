import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] array = new int[4];
        
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;
        
        Arrays.sort(array);
        
        if(array[0]==array[3]){
            answer = array[0] * 1111;
        }
        else if(array[0]==array[2]){
            answer = (int)Math.pow(10 * array[0] + array[3], 2);
        }
        else if(array[1]==array[3]){
            answer = (int)Math.pow(10 * array[1] + array[0], 2);
        }
        else if(array[0]==array[1] && array[2]==array[3]){
            answer = (array[0] + array[2]) * Math.abs(array[0] - array[2]);
        }
        else if(array[0]==array[1] && array[2]!=array[3]){
            answer = array[2] * array[3];
        }
        else if(array[1]==array[2] && array[0]!=array[3]){
            answer = array[0] * array[3];
        }
        else if(array[2]==array[3] && array[0]!=array[1]){
            answer = array[0] * array[1];
        }
        else{
            answer = array[0];
        }
        return answer;
        
    }
}