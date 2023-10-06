class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] keyword = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
        };
        
        for(int i=0; i<keyword.length; i++){
            s = s.replaceAll(keyword[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}