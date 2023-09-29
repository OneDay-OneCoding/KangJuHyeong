class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계. 대문자 -> 소문자 변환
        answer = new_id.toLowerCase();
        
        // 2단계. 특수문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        // 3단계. 온점 변환(.도 예약어이고, \도 예약어이다.)
        answer = answer.replaceAll("\\.","#");
        
        int length;
        do{
            length = answer.length();
            answer = answer.replaceAll("##","#");
        } while(length != answer.length());
        answer = answer.replaceAll("#","\\.");
        
        // 4단계. 아이디의 처음과 끝에 위치한 온점 제거
        if(answer.substring(0,1).equals(".")){
            answer = answer.substring(1, answer.length());
        }
        if(answer.length()!=0){
            if(answer.substring(answer.length()-1, answer.length()).equals(".")){
                answer = answer.substring(0, answer.length()-1);
            } 
        }
        
        // 5단계. 아이디가 빈 문자열이라면, new_id에 "a"를 대입한다.
        if(answer.length() == 0){
            answer = "a";
        }
        
        // 6단계. 아이디의 길이가 16자 이상이라면, 첫 15개 문자를 제외한 나머지를 모두 제거한다.
        if(answer.length() > 15){
            answer = answer.substring(0,15);
            
            if(answer.substring(answer.length()-1, answer.length()).equals(".")){
                answer = answer.substring(0, answer.length()-1);
            }
        }
        
        // 7단계. 아이디의 길이가 2자 이하라면, 길이가 3이 될 때까지 마지막 문자를 반복해서 붙인다.
        if(answer.length() <= 2){
            while(true){
                if(answer.length() >= 3){
                    break;
                }
                else{
                    answer += answer.substring(answer.length()-1, answer.length());
                }
            }
        }
        
        return answer;
    }
}