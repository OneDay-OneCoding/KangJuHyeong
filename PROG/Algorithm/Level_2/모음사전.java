import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        String[] str = {"A","E","I","O","U"};
        HashMap<String, Integer> dictionary = new HashMap<>(); // <문자열, 사전순서>를 저장할 사전
        
        // word가 사전에서 몇 번째 단어인지 완전탐색한다.
        // A = 1,E = 2, I = 3, O = 4, U = 5로 소수점에 대입해보자.
        
        // -> "AAAA" = 4번째, "AAAE" = 10번째
        //  "A", "AA", "AAA", "AAAA", "AAAAA", 
        //  "AAAAE", "AAAAI", "AAAAO", "AAAAU", "AAAE"
        // "AAAEA", "AAAEE", "AAAEI", "AAAEO", "AAAEU"
        // "AAAI" ...
        
        String s = ""; // word와 일치하는 단어를 찾기 위해 현재 제작중인 문자열
        int count = 0; // 단어가 사전에 위치한 순서
        
        for(int i=0; i<str.length; i++){
            s += str[i];
            dictionary.put(s, ++count);
            for(int j=0; j<str.length; j++){
                s += str[j];
                dictionary.put(s, ++count);
                for(int k=0; k<str.length; k++){
                    s += str[k];
                    dictionary.put(s, ++count);
                    for(int m=0; m<str.length; m++){
                        s += str[m];
                        dictionary.put(s, ++count);
                        for(int n=0; n<str.length; n++){
                            if(s.length() == 4){
                                s += str[n];    
                            }
                            else{
                                s = s.substring(0,4) + str[n];  
                            }
                            dictionary.put(s, ++count);
                        }
                        s = s.substring(0,3);
                    }
                    s = s.substring(0,2);
                }
                s = s.substring(0,1);
            }
            s = "";
        }
        
        try{
            answer = dictionary.get(word);    
        } catch(NullPointerException e){
            answer = 0;
        }
        
        return answer;
    }
}