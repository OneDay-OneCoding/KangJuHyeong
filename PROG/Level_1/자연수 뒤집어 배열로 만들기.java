class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        char[] array = str.toCharArray();
        int[] answer = new int[array.length];
        
        for(int i=0; i<array.length; i++){
            answer[i] = array[array.length-1-i]-'0';
        }
        return answer;
    }
}