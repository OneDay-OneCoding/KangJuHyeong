class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        
        for(int i=0; i<picture.length; i++){
            char[] original = picture[i].toCharArray();
            char[] expansion = new char[picture[i].length()*k];
            for(int m=0; m<picture[i].length(); m++){
                for(int n=m*k; n<m*k+k; n++){
                    expansion[n] = original[m];    
                }
            }
            
            for(int j=i*k; j<i*k+k; j++){
                answer[j] = new String(expansion);
            }
        }
        return answer;
    }
}