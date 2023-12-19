class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int[] countX = new int[10];
        int[] countY = new int[10];
        int[] countAll = new int[10];
        char[] arrayX = X.toCharArray();
        char[] arrayY = Y.toCharArray();
        
        for(int i=0; i<arrayX.length; i++){
            countX[arrayX[i]-'0']++;
        }
        
        for(int i=0; i<arrayY.length; i++){
            countY[arrayY[i]-'0']++;
        }
        
        for(int i=0; i<countX.length; i++){
            countAll[i] = Math.min(countX[i], countY[i]);
        }
        
        for(int i=countX.length-1; i>=0; i--){
            if(countAll[i] > 0){
                while(true){
                    if(countAll[i] == 0){
                        break;
                    }
                    else{
                        sb.append(i);
                        countAll[i]--;
                    }
                }
            }
        }
        
        answer = sb.toString();
        if(answer.equals("")){
            answer = "-1";
        }
        else if(answer.substring(0,1).equals("0")){
            answer = "0";
        }
        
        return answer;
    }
}