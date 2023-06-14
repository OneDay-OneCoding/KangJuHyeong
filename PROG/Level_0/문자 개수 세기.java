class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char[] array = my_string.toCharArray();
        for(int i=0; i<array.length; i++){
            if(array[i]>='A' && array[i]<='Z'){
                answer[array[i]-65]++;    
            }
            else if(array[i]>='a' && array[i]<='z'){
                answer[array[i]-97+26]++;
            }
        }
        return answer;
    }
}