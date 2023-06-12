class Solution {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        char[] strArray = my_string.toCharArray();
        char[][] array = new char[strArray.length/m][m];
        
        int index = 0;
        for(int i=0; i<strArray.length/m; i++){
            for(int j=0; j<m; j++){
                array[i][j] = strArray[index++];
            }
        }
        
        for(int i=0; i<strArray.length/m; i++){
            answer += array[i][c-1];
        }
        return answer;
    }
}