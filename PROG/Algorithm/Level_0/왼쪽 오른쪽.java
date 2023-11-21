class Solution {
    public String[] solution(String[] str_list) {
        String[] answer = {};
        
        int index = -1;
        String direction = "";
        for(int i=0; i<str_list.length; i++){
            if(str_list[i].equals("l") || str_list[i].equals("r")){
                direction = str_list[i];
                index = i;
                break;
            }
        }
        
        if(index!=-1){
            if(direction.equals("r")){
                answer = new String[str_list.length-index-1];
                for(int i=0; i<str_list.length-index-1; i++){
                    answer[i] = str_list[i+index+1];
                }    
            }
            else if(direction.equals("l")){
                answer = new String[index];
                for(int i=0; i<index; i++){
                    answer[i] = str_list[i];
                }
            }
        }
        return answer;
    }
}