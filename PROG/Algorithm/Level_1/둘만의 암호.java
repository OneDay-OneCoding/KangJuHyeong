class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] array = s.toCharArray();
        char[] restrict = skip.toCharArray();
        
        for(int i=0; i<array.length; i++){
            int count = 0;
            
            while(true){
                if(count == index){
                    break;
                }
                else{
                    char next = (char)(array[i]+1);
                    
                    boolean check = true;
                    if(Character.isLetter(next)){
                        for(int j=0; j<restrict.length; j++){
                            if(next == restrict[j]){
                                array[i] = next;
                                check = false;
                                break;
                            }
                        }
                        if(check){
                            array[i] = next;
                            count++;
                        }
                    }
                    else{
                        array[i] = 'a';
                        for(int j=0; j<restrict.length; j++){
                            if(array[i] == restrict[j]){
                                array[i] = (char)(array[i]+1);
                                    
                                // 테스트케이스 8번 실패.
                                // skip의 문자열은 별도로 정렬하지 않았기 때문에,
                                // 'z' -> 'a'로 넘어가는 구간에서는
                                // 다음 문자가 skip의 문자에 해당할 경우
                                // 다시 첫번째 인덱스부터 검사해줘야한다.
                                j = -1;
                            }
                        }
                        count++;
                    }
                }
            }
        }
        
        return new String(array);
    }
}