class Solution {
    public String solution(String phone_number) {
        String answer = "";
        char[] array = phone_number.toCharArray();
        
        for(int i=array.length-5; i>=0; i--){
            array[i] = '*';
        }
        answer = new String(array);
        return answer;
    }
}