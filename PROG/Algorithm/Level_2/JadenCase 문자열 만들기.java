class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        
        for(int i=0; i<str.length; i++){
            if(str[i].length()!=0 ){
                if(str[i].substring(0,1).matches("[a-z]")){
                    answer += str[i].substring(0,1).toUpperCase() + str[i].substring(1, str[i].length()).toLowerCase();
                }
                else{
                    answer += str[i].substring(0,1) + str[i].substring(1, str[i].length()).toLowerCase();
                }

                while(true){
                    if(i != str.length-1 && s.substring(answer.length(), answer.length()+1).equals(" ")){
                        answer += " ";    
                    }
                    else{
                        break;
                    }
                }    
            }
        }
        
        // 테스트케이스 8번. 문자열의 끝에 공백이 붙어있는 경우에 대한 로직
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            answer += " ";
        }
        
        return answer;
    }
}