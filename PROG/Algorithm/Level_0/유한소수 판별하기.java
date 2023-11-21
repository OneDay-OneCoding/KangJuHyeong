import java.util.*;

class Solution {
    public int solution(int a, int b) {
        int answer = 1;
        int gcd = 1;
        int count = 1;
        
        while(true){
            if(count > b){
                break;
            }    
            else{
                if((a % count == 0) && (b % count == 0)){
                    gcd = count;
                }
                count++;
            }
        }
        a /= gcd;
        b /= gcd;
        
        List<Integer> list = new ArrayList<Integer>();
        count = 2;
        while(true){
            if(count > b){
                break;
            }
            else{
                if(b % count == 0){
                    list.add(count);
                    b /= count;
                }
                else{
                    count++;
                }
            }
        }
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==2 || list.get(i)==5){
                continue;
            }
            else{
                answer = 2;
            }
        }

        return answer;
    }
}