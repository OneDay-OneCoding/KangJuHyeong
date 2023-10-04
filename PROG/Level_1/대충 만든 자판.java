class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        // 하나의 target에 대해, keymap에 존재하는 모든 키맵들을 대상으로
        // 해당 target을 만들어낼 수 있는지의 여부와 최소 카운트를 산출한다. 
        for(int i=0; i<targets.length; i++){
            // 1. target 선택
            String target = targets[i];
            char[] array = target.toCharArray();
            
            // 2. target 문자열의 한 글자 선택
            // target의 각각의 글자들을 표현한 array에 대해
            // 모든 keymap의 카운트 여부를 계산하여 비교한다.
            for(int j=0; j<array.length; j++){
                int[] count = new int[keymap.length];
                
                // 3. keymap 선택
                for(int k=0; k<keymap.length; k++){
                    char[] keyArray = keymap[k].toCharArray();

                    // 4. target 문자열의 한 글자와 keymap의 한 글자끼리 비교
                    for(int l=0; l<keyArray.length; l++){
                        if(array[j] == keyArray[l]){
                            count[k] = (l+1);
                            break;
                        }
                    }
                }
                
                int min = Integer.MAX_VALUE;
                    // 5. 전체 keymap중 최소 카운트를 가진 keymap으로 결정
                    for(int m=0; m<count.length; m++){
                        if(count[m] != 0){
                            min = Math.min(min, count[m]);    
                        }
                    }
                if(min == Integer.MAX_VALUE){
                    answer[i] = -1;  
                    break;
                }
                else{
                    answer[i] += min;    
                }
            }
        }
        
        return answer;
    }
}