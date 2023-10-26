class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] order = new String[skill_trees.length];
        
        // order 배열 초기화
        for(int i=0; i<order.length; i++){
            order[i] = "";
        }
        
        // 각 문자별 인덱스를 스킬에 맞게 대응한 뒤
        // 서브스트링 값이 skill과 일치하지 않는 경우
        // 불가능한 스킬트리라 판단한다.
        
        // BACDE -> CBD : 203 (X) "BCD" != "CBD"
        // CBADF -> CBD : 013 (O) "CBD" == "CBD"
        // AECB  -> CBD : 23  (O) "CB" == "CB"
        // BDA   -> CBD : 01  (X) "BD" != "CB"
        for(int i=0; i<skill_trees.length; i++){
            String[] str = skill_trees[i].split("");
            String[] compare = skill.split("");
            
            // skill_trees의 한 문자별로 대응되는 skill 문자를 order 배열에 추가한다.
            for(int j=0; j<str.length; j++){
                String target = str[j];
                
                for(int k=0; k<compare.length; k++){
                    if(target.equals(compare[k])){
                        order[i] += target;
                    }    
                }
            }
        }
        
        for(int i=0; i<order.length; i++){
            if(order[i].equals(skill.substring(0, order[i].length()))){
                answer += 1;
            }
        }
        
        return answer;
    }
}