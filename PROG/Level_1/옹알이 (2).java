class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya","ye","woo","ma"};
        String[] restrict = {"ayaaya","yeye","woowoo","mama"};
        
        for(int i=0; i<babbling.length; i++){
            // 같은 발음을 연속해서 하는게 제한된거지, 여러번하는게 제한된게 아니다.
            // "ayaaya" -> (X) "ayayeaya" -> (O)
            boolean check = false;
            for(int j=0; j<restrict.length; j++){
                if(babbling[i].contains(restrict[j])){
                    check = true;
                    break;
                }
            }
            if(check){
                continue;
            }
            
            for(int j=0; j<word.length; j++){
                babbling[i] = babbling[i].replaceAll(word[j], "@");
            }
            babbling[i] = babbling[i].replaceAll("@","");
            if(babbling[i].equals("")){
                answer++;
            }
        }
            
        return answer;
    }
}